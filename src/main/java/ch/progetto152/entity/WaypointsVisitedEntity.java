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
