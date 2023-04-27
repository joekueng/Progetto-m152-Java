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
@Table(name = "Location", schema = "Progetto152", catalog = "")
public class LocationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocationEntity that = (LocationEntity) o;
        return Double.compare(that.lat, lat) == 0 && Double.compare(that.lon, lon) == 0 && Objects.equals(location, that.location) && Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, region, lat, lon);
    }
}
