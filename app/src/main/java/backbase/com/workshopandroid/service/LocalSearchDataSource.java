package backbase.com.workshopandroid.service;

import android.content.Context;
import android.content.res.AssetManager;

import com.backbase.android.core.utils.StringUtils;
import com.backbase.android.widget.places.core.callback.SearchLocationListener;
import com.backbase.android.widget.places.core.contract.SearchDataSourceContract;
import com.backbase.android.widget.places.core.model.SearchLocation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import backbase.com.workshopandroid.dto.response.LocalLocation;

/**
 * Created by Backbase R&D B.V on 25/09/2017.
 */
public class LocalSearchDataSource implements SearchDataSourceContract {

    private String assetPath = "";
    private Context context;
    private List<SearchLocation> locations;

    public LocalSearchDataSource(Context context) throws IOException, JsonSyntaxException {
        this.assetPath = "backbase/demo-places-presentation-service/locationsNL.json";
        this.context = context;
        readFile();
    }

    public void readFile() throws JsonSyntaxException, IOException {
        AssetManager assets = this.context.getAssets();
        InputStream stream = assets.open(assetPath);
        String ret = StringUtils.getString(stream);
        if (stream != null) {
            stream.close();
        }

        Gson gson = new GsonBuilder().serializeNulls().create();
        Type listType = new TypeToken<List<LocalLocation>>() {
        }.getType();
        List<LocalLocation> localLocations = gson.fromJson(ret, listType);
        locations = new ArrayList<>();
        if (localLocations != null && !localLocations.isEmpty()) {
            for (LocalLocation localLocation : localLocations) {
                locations.add(new SearchLocation(localLocation.getId(), localLocation.getCoord().getLat(),
                        localLocation.getCoord().getLon(), localLocation.getName(), localLocation.getCountry()));
            }
        }
    }

    @Override
    public void search(String searchQuery, SearchLocationListener searchLocationListener) {
        List<SearchLocation> foundLocations = new ArrayList<>();
        for (SearchLocation location : locations) {
            if (location.getTitle() != null && location.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                foundLocations.add(location);
            }
        }
        searchLocationListener.onSuccess(foundLocations);
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }
}
