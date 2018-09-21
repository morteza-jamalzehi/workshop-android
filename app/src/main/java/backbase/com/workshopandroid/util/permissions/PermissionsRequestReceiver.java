package backbase.com.workshopandroid.util.permissions;

/**
 * Created by Backbase R&D B.V on 26/09/2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

import backbase.com.workshopandroid.BaseActivity;

public class PermissionsRequestReceiver extends BroadcastReceiver {

    private final int permissionsRequestCode;
    private ArrayList<String> previouslyGrantedPermissions;
    private BaseActivity baseActivity;

    public PermissionsRequestReceiver(@NonNull BaseActivity baseActivity, int permissionsRequestCode) {
        this.baseActivity = baseActivity;
        this.permissionsRequestCode = permissionsRequestCode;
        previouslyGrantedPermissions = new ArrayList<>();
    }

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        String[] permissionsRequested = PermissionsRequestConverter.fromIntent(intent);
        ArrayList<String> permissionsRequired = new ArrayList<>();
        for (String permissionRequested : permissionsRequested) {
            if (ContextCompat.checkSelfPermission(baseActivity, permissionRequested) == PackageManager.PERMISSION_GRANTED) {
                previouslyGrantedPermissions.add(permissionRequested);
            } else {
                permissionsRequired.add(permissionRequested);
            }
        }
        if (!permissionsRequired.isEmpty()) {
            ActivityCompat.requestPermissions(baseActivity, permissionsRequired.toArray(new String[0]), permissionsRequestCode);
        } else {
            baseActivity.sendPermissionsResult(previouslyGrantedPermissions, new String[0], new int[0]); //Will be called when all requested permissions are granted previously or when no permissions are required (older versions of Android).
        }
    }

    @NonNull
    public ArrayList<String> getPreviouslyGrantedPermissions() {
        return previouslyGrantedPermissions;
    }
}