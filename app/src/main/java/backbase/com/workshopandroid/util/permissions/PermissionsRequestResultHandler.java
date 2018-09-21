package backbase.com.workshopandroid.util.permissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;

import backbase.com.workshopandroid.dto.PermissionsResponse;

/**
 * Created by Backbase R&D B.V on 26/09/2017.
 */

public class PermissionsRequestResultHandler {

    /**
     * Hide constructor
     */
    private PermissionsRequestResultHandler() {
    }

    @NonNull
    public static String extractPermissionsResultPayload(@NonNull ArrayList<String> permissionsAlreadyGiven, @NonNull String[] permissions, @NonNull int[] grantResults) {
        ArrayList<String> permissionsGranted = new ArrayList<>();
        ArrayList<String> permissionsDenied = new ArrayList<>();

        permissionsGranted.addAll(permissionsAlreadyGiven);
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                permissionsGranted.add(permissions[i]);
            } else {
                permissionsDenied.add(permissions[i]);
            }
        }

        PermissionsResponse permissionsResponse = new PermissionsResponse(permissionsGranted, permissionsDenied);
        return new Gson().toJson(permissionsResponse);
    }
}
