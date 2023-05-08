package ch.progetto152.repository;

import ch.progetto152.entity.WaypointsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WaypointRepository extends JpaRepository<WaypointsEntity, Long> {

    Optional<List<WaypointsEntity>> findAllByLocationName(String locationName);

}
