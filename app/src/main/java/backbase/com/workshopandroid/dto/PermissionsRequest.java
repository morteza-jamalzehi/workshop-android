package backbase.com.workshopandroid.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Backbase R&D B.V on 27/09/2017.
 */
public class PermissionsRequest {
    @SerializedName("permissions")
    @Expose
    private String[] permissions;

    /**
     * No args constructor for use in serialization
     */
    public PermissionsRequest() {
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }
}
