package ch.progetto152.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Waypoints", schema = "Progetto152", catalog = "")
public class WaypointsEntity {
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
    @Column(name = "locationName")
    private String locationName;

    public WaypointsEntity(String name, double lat, double lon, String description, String img, String locationName) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.img = img;
        this.locationName = locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WaypointsEntity that = (WaypointsEntity) o;
        return id == that.id && Double.compare(that.lat, lat) == 0 && Double.compare(that.lon, lon) == 0 && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(img, that.img) && Objects.equals(locationName, that.locationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lat, lon, description, img, locationName);
    }

    public String getLocationName() {
        return locationName;
    }
}
