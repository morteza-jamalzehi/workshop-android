package backbase.com.workshopandroid;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.backbase.android.Backbase;
import com.backbase.android.client.places.PlacesClient;
import com.backbase.android.client.productsummary.ProductSummaryClient;
import com.backbase.android.dbs.dataproviders.AssetsFileDBSDataProvider;
import com.backbase.android.rendering.BBRenderer;
import com.backbase.android.widget.places.core.PlacesWidget;
import com.backbase.android.widget.productsummary.core.ProductSummaryWidget;

import java.net.URI;
import java.net.URISyntaxException;

import backbase.com.workshopandroid.client.LocalPlacesDBSDataProvider;

import backbase.com.workshopandroid.widget.morteza_sample_widget.core.LoginWidget;
import backbase.com.workshopandroid.widget.sample_widget.widget.core.SampleWidgetWidget;
import sadad.test.test_widget.widget.core.testWidgetWidget;

/**
 * Created by Backbase R&D B.V on 09/11/2017.
 */

public class WorkshopApplication extends Application {

    private static final String TAG = WorkshopApplication.class.getSimpleName();
    //Permissions
    public static final String PERMISSIONS_REQUEST = "bb.action.permissions.request";
    public static final String PERMISSIONS_RESPONSE = "bb.action.permissions.response";
    public static final String EVENT_DATA = "EVENT_DATA";

    public static final String OPEN_PRODUCT_SUMMARY_FLOW = "flow.open.productsummary";
    public static final String OPEN_PLACES_FLOW = "flow.open.places";
    public static final String OPEN_WELCOME_FLOW = "flow.open.welcome";
    public static final String OPEN_SAMPLE_FLOW = "flow.open.sample";

    public static final String TAG_EXPERIENCE_ID = "ExperienceId";

    @Override
    public void onCreate() {
        super.onCreate();
        Backbase.setLogLevel(Backbase.LogLevel.DEBUG); //Set the debug level. Debug level DEBUG means that all debug logs logged with BBLogger will be logged.
        Backbase.initialize(this, "backbase/conf/configuration.json", false);
        registerRenderers();
        registerClients();
    }


    private void registerRenderers() {
        //register renderers here
        BBRenderer.registerRenderer(ProductSummaryWidget.class);
        BBRenderer.registerRenderer(PlacesWidget.class);
        BBRenderer.registerRenderer(SampleWidgetWidget.class);
//        BBRenderer.registerRenderer(testWidgetWidget.class);
        BBRenderer.registerRenderer(LoginWidget.class);
//        BBRenderer.registerRenderer(LoginWidget.class);

    }

    private void observeEvent() {
        Backbase.getInstance().registerObserver("sd", new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        });
    }

    private void registerClients() {
        //register clients here
        try {
            Backbase.getInstance().registerClient(new ProductSummaryClient(new AssetsFileDBSDataProvider(this), new URI("backbase")));
            Backbase.getInstance().registerClient(new PlacesClient(new LocalPlacesDBSDataProvider(this), new URI("backbase")));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
