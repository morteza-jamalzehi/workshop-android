package backbase.com.workshopandroid;

import android.content.BroadcastReceiver;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.backbase.android.Backbase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import backbase.com.workshopandroid.util.permissions.PermissionsRequestReceiver;
import backbase.com.workshopandroid.util.permissions.PermissionsRequestResultHandler;

import static backbase.com.workshopandroid.WorkshopApplication.PERMISSIONS_REQUEST;
import static backbase.com.workshopandroid.WorkshopApplication.PERMISSIONS_RESPONSE;


/**
 * Created by Backbase R&D B.V on 29/08/2017.
 * Abstract activity which contains logic about registering deregistering observers without the possibility of forgetting to register / deregister. This does requires activities to implement the mapObservers method.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected List<MyReceiver> broadcastReceivers = new ArrayList<>();
    protected Backbase backbase;
    private PermissionsRequestReceiver permissionsRequestReceiver = new PermissionsRequestReceiver(this, getPermissionsRequestCode());

    /**
     * Map the observers to the broadCastReceivers HashMap here. The BaseBackBaseActivity will take care of registering and deregistering the observers on time. This method will be called onCreate.
     */
    abstract void mapObservers();

    abstract int getPermissionsRequestCode();

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backbase = Backbase.getInstance();
        mapDefaultObservers();
        mapObservers();
    }

    private void mapDefaultObservers() {
        broadcastReceivers.add(new MyReceiver(PERMISSIONS_REQUEST, permissionsRequestReceiver));
    }

    @CallSuper
    @Override
    protected void onPause() {
        deregisterObservers();
        super.onPause();
    }

    @CallSuper
    @Override
    protected void onResume() {
        registerObservers();
        super.onResume();
    }

    private void registerObservers() {
        for (MyReceiver myReceiver : broadcastReceivers) {
            backbase.registerObserver(myReceiver.getEvent(), myReceiver.getBroadcastReceiver());
        }
    }

    private void deregisterObservers() {
        for (MyReceiver myReceiver : broadcastReceivers) {
            backbase.unregisterObserver(myReceiver.getBroadcastReceiver());
        }
    }

    public void addObserver(String event, BroadcastReceiver broadcastReceiver) {
        broadcastReceivers.add(new MyReceiver(event, broadcastReceiver));
    }

    public void addAndRegisterObserver(String event, BroadcastReceiver broadcastReceiver) {
        broadcastReceivers.add(new MyReceiver(event, broadcastReceiver));
        backbase.registerObserver(event, broadcastReceiver);
    }

    public void removeAndDeregisterObserver(String event) {
        MyReceiver myReceiver = findReceiverByEvent(event);
        if (myReceiver != null) {
            backbase.unregisterObserver(myReceiver.getBroadcastReceiver());
        }
    }

    private MyReceiver findReceiverByEvent(String event) {
        for (MyReceiver myReceiver : broadcastReceivers) {
            if (myReceiver.getEvent().equals(event)) {
                return myReceiver;
            }
        }

        return null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @CallSuper
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == getPermissionsRequestCode()) {
            sendPermissionsResult(permissionsRequestReceiver.getPreviouslyGrantedPermissions(), permissions, grantResults);
        }
    }

    public void sendPermissionsResult(ArrayList<String> previouslyGrantedPermissions, String[] permissions, int[] grantResults) {
        String payload = PermissionsRequestResultHandler.extractPermissionsResultPayload(previouslyGrantedPermissions, permissions, grantResults);
        try {
            backbase.publishEvent(PERMISSIONS_RESPONSE, new JSONObject(payload));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class MyReceiver {
        private String event;
        private BroadcastReceiver broadcastReceiver;

        public MyReceiver(String event, BroadcastReceiver broadcastReceiver) {
            this.event = event;
            this.broadcastReceiver = broadcastReceiver;
        }

        public String getEvent() {
            return event;
        }

        public BroadcastReceiver getBroadcastReceiver() {
            return broadcastReceiver;
        }
    }

}
