package backbase.com.workshopandroid.dto.response;

/**
 * Created by Backbase R&D B.V on 25/09/2017.
 */
public class Coordinates {
    private double lon;
    private double lat;

    public Coordinates() {
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
