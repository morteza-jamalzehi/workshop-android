package backbase.com.workshopandroid.dto.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Backbase R&D B.V on 21/08/2017.
 * AuthorizationErrorResponse will be sent from the server when a authentication (401) response gets send.
 */

public class AuthorizationErrorResponse {

    @SerializedName("error")
    public ErrorType error;
    @SerializedName("message")
    public String message;

    @SuppressWarnings("WeakerAccess") // incorrect warning. It's important for GSON deserialization
    public enum ErrorType {
        @SerializedName("invalid_refresh_token")
        INVALID_REFRESH_TOKEN,
        @SerializedName("invalid_access_token")
        INVALID_ACCESS_TOKEN,
        @SerializedName("invalid_credentials")
        INVALID_CREDENTIALS
    }

}
