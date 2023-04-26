package ch.progetto152.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class LocationVisited{

    @Id
    @Basic
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "locationid")
    private int locationid;
    @Id
    private Long id;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocationVisited that = (LocationVisited) o;
        return userId == that.userId && locationid == that.locationid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, locationid);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
