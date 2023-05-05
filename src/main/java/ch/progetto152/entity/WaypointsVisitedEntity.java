package ch.progetto152.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "WaypointsVisited", schema = "Progetto152", catalog = "")
@IdClass(WaypointsVisitedId.class)
public class WaypointsVisitedEntity {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Id
    @Column(name = "waypoint_id")
    private int waypointId;

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

class WaypointsVisitedId implements Serializable {
    private int userId;
    private int waypointId;
}
