package backbase.com.workshopandroid.client;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.backbase.android.client.places.domain.Place;
import com.backbase.android.core.networking.ErrorResponse;
import com.backbase.android.core.networking.Request;
import com.backbase.android.core.networking.ResponseCodes;
import com.backbase.android.dbs.DBSDataProviderListener;
import com.backbase.android.dbs.dataproviders.AssetsFileDBSDataProvider;
import com.backbase.android.utils.net.RequestMethods;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Backbase R&D B.V on 17/10/2017.
 */

public class LocalPlacesDBSDataProvider extends AssetsFileDBSDataProvider {

    private static final long FAKE_DELAY = 500L;
    private final Context context;
    private ResponseType responseType = ResponseType.SUCCESS;
    private int responseCode = ResponseCodes.SUCCESS.getCode();

    public LocalPlacesDBSDataProvider(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void execute(final Request request, final DBSDataProviderListener listener) {
        if (request.getRequestMethod().equals(RequestMethods.GET.name())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (responseType) {
                        case SUCCESS:
                            try {
                                buildAndPassResponse(filterResponse(readFile(request.getUri().getPath()), request.getUri().getQuery()), listener, responseCode);
                            } catch (IOException e) {
                                buildAndPassResponse("CANNOT PARSE FILE", listener, ResponseCodes.ERROR.getCode());
                            }
                            break;
                        case NETWORK_ERROR:
                            listener.onError(new ErrorResponse("ERROR FROM SERVER", responseCode));
                            break;
                        case NO_RESULTS:
                            buildAndPassResponse(filterResponse("[]", request.getUri().getQuery()), listener, responseCode);
                            break;
                    }
                }
            }, FAKE_DELAY);
        } else {
            this.buildAndPassResponse("METHOD \'" + request.getRequestMethod() + "\' IS NOT ALLOWED", listener, ResponseCodes.METHOD_NOT_ALLOWED.getCode());
        }
    }

    private String filterResponse(String responseBody, String query) {
        Type listType = new TypeToken<List<Place>>() {
        }.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        List<Place> placeItems = gson.fromJson(responseBody, listType);
        double latitude = getDoubleParam(query, "latitude");
        double longitude = getDoubleParam(query, "longitude");
        double radius = getDoubleParam(query, "radius");

        placeItems = filterByRadius(placeItems, latitude, longitude, radius);

        return gson.toJson(placeItems);
    }

    private List<Place> filterByRadius(List<Place> placeItems, double centerLatitude, double centerLongitude, double radius) {
        ArrayList<Place> placeItemsOut = new ArrayList<>();
        for (Place placeItem : placeItems) {
            float[] results = new float[1];
            Location.distanceBetween(centerLatitude, centerLongitude, placeItem.getLatitude(), placeItem.getLongitude(), results);

            if (results[0] / 1000 < radius) {
                placeItemsOut.add(placeItem);
            }
        }

        return placeItemsOut;
    }

    private double getDoubleParam(String query, String paramName) {
        String param = getParam(query, paramName);
        if (param == null) {
            return -1;
        }
        return Double.parseDouble(param);
    }

    @Nullable
    private String getParam(String query, String paramName) {
        if (query.contains(paramName)) {
            for (String paramPair : query.split("&")) {
                if (paramPair.split("=")[0].equals(paramName)) {
                    return paramPair.split("=")[1];
                }
            }
        }
        return null;
    }

    public void setResponseType(@NonNull ResponseType responseType) {
        this.responseType = responseType;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public enum ResponseType {
        SUCCESS,
        NO_RESULTS,
        NETWORK_ERROR
    }
}

