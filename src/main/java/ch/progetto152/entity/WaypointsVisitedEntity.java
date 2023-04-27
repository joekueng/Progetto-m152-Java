package ch.progetto152.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "WaypointsVisited", schema = "Progetto152", catalog = "")
public class WaypointsVisitedEntity {
    @Basic
    @Id
    @Column(name = "userId")
    private int userId;
    @Basic
    @Id
    @Column(name = "waypointId")
    private int waypointId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(int waypointId) {
        this.waypointId = waypointId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WaypointsVisitedEntity that = (WaypointsVisitedEntity) o;
        return userId == that.userId && waypointId == that.waypointId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, waypointId);
    }
}
