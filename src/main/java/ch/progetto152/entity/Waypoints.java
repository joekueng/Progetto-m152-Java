package ch.progetto152.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Waypoints", schema = "Progetto152", catalog = "")
public class Waypoints {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "lat")
    private double lat;
    @Basic
    @Column(name = "lon")
    private double lon;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "LocationId")
    private int locationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Waypoints that = (Waypoints) o;
        return id == that.id && Double.compare(that.lat, lat) == 0 && Double.compare(that.lon, lon) == 0 && locationId == that.locationId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(img, that.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lat, lon, description, img, locationId);
    }
}
