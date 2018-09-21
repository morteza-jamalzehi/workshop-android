package backbase.com.workshopandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.backbase.android.Backbase;
import com.backbase.android.listeners.NavigationEventListener;
import com.backbase.android.navigation.NavigationEvent;

import org.json.JSONException;
import org.json.JSONObject;

import static backbase.com.workshopandroid.WorkshopApplication.OPEN_PLACES_FLOW;
import static backbase.com.workshopandroid.WorkshopApplication.OPEN_PRODUCT_SUMMARY_FLOW;
import static backbase.com.workshopandroid.WorkshopApplication.OPEN_SAMPLE_FLOW;
import static backbase.com.workshopandroid.WorkshopApplication.OPEN_WELCOME_FLOW;
import static backbase.com.workshopandroid.WorkshopApplication.TAG_EXPERIENCE_ID;

public class MainActivity extends AppCompatActivity {

    private String currentPageId;
    private OnNavigationEventListenerImpl onNavigationEventListener = new OnNavigationEventListenerImpl();
    private OnNavigationItemSelectedListenerImpl onNavigationItemSelectedListener = new OnNavigationItemSelectedListenerImpl();
    private Backbase backbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backbase = Backbase.getInstance();
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        backbase.registerNavigationEventListener(onNavigationEventListener);


        initFirstPage();
    }

    private void initFirstPage() {
        Intent intent = getIntent();
        if (intent != null) {
            currentPageId = intent.getStringExtra(TAG_EXPERIENCE_ID);
            backbase.publishEvent(OPEN_SAMPLE_FLOW, currentPageId, new JSONObject());
        } else {
            finish();
        }
    }


    void replaceFragment(String pageId) {
        currentPageId = pageId;
        PageFragment pageFragment = PageFragment.newInstance(pageId);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, pageFragment).commit();
    }


    private class OnNavigationEventListenerImpl implements NavigationEventListener {
        @Override
        public void onNavigationEvent(NavigationEvent navigationEvent) {
            String pageId = navigationEvent.getTargetPageUri();
            replaceFragment(pageId);
            String payload = navigationEvent.getTargetPageUri();
        }
    }

    private class OnNavigationItemSelectedListenerImpl implements BottomNavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_product_summary:
                    backbase.publishEvent(OPEN_PRODUCT_SUMMARY_FLOW, currentPageId, new JSONObject());
                    return true;
                case R.id.navigation_places:
                    backbase.publishEvent(OPEN_PLACES_FLOW, currentPageId, new JSONObject());
                    return true;
                case R.id.navigation_welcome:
                    backbase.publishEvent(OPEN_WELCOME_FLOW, currentPageId, new JSONObject());
                    return true;
                case R.id.navigation_sample:
                    JSONObject payload = new JSONObject();
                    try {
                        payload.put("accountID", 12456);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    backbase.publishEvent(OPEN_SAMPLE_FLOW, currentPageId, payload);
                    return true;
            }
            return false;
        }
    }
}
