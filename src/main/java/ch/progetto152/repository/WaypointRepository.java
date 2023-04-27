package ch.progetto152.repository;

import ch.progetto152.entity.Waypoints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaypointRepository extends JpaRepository<Waypoints, Long> {

    Optional<Waypoints> findWaypointByName(String name);
}
