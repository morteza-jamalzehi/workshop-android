package backbase.com.workshopandroid.dto.response;

/**
 * Created by Backbase R&D B.V on 25/09/2017.
 */
public class LocalLocation {
    private String country;
    private String name;
    private String id;
    private Coordinates coord;

    public LocalLocation() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }
}
