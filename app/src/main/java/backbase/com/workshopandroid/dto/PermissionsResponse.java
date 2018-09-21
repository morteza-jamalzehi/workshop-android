package backbase.com.workshopandroid.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Backbase R&D B.V on 25/09/2017.
 * Pojo class used by BaseActivity as payload to the event being triggered after the result of requesting permissions is received on Activity level.
 */
@SuppressWarnings("WeakerAccess") //Required for Gson
public class PermissionsResponse {

    @SerializedName("granted")
    @Expose
    public List<String> granted = null;
    @SerializedName("denied")
    @Expose
    public List<String> denied = null;

    /**
     * No args constructor for use in serialization
     */
    @SuppressWarnings("unused")
    public PermissionsResponse() {
    }

    /**
     * @param denied  all the denied permissions
     * @param granted all the granted permissions
     */
    public PermissionsResponse(List<String> granted, List<String> denied) {
        super();
        this.granted = granted;
        this.denied = denied;
    }

}