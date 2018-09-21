package backbase.com.workshopandroid.util.permissions;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import backbase.com.workshopandroid.dto.PermissionsRequest;

import static backbase.com.workshopandroid.WorkshopApplication.EVENT_DATA;

/**
 * Created by Backbase R&D B.V on 25/09/2017.
 */

public class PermissionsRequestConverter {

    /**
     * Hide constructor
     */
    private PermissionsRequestConverter() {
    }

    public static String[] fromIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String payload = extras.getString(EVENT_DATA);
            if (payload != null && !payload.isEmpty()) {
                Gson gson = new Gson();
                PermissionsRequest permissionsRequest = gson.fromJson(payload, PermissionsRequest.class);
                return permissionsRequest.getPermissions();
            }
        }
        return new String[0];
    }
}
