package ch.progetto152.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Location", schema = "Progetto152", catalog = "")
public class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "region")
    private String region;
    @Basic
    @Column(name = "lat")
    private double lat;
    @Basic
    @Column(name = "lon")
    private double lon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location that = (Location) o;
        return id == that.id && Double.compare(that.lat, lat) == 0 && Double.compare(that.lon, lon) == 0 && Objects.equals(location, that.location) && Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, region, lat, lon);
    }
}
