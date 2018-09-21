package backbase.com.workshopandroid.dto;

/**
 * Created by Backbase R&D B.V on 02/10/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchValue {
    @SerializedName("value")
    @Expose
    public String value;

    public SearchValue(String value) {
        this.value = value;
    }
}