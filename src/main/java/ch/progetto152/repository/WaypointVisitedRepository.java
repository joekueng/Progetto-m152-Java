package ch.progetto152.repository;

import ch.progetto152.entity.WaypointsVisitedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaypointVisitedRepository extends JpaRepository<WaypointsVisitedEntity, Long> {
    Optional<WaypointsVisitedEntity> findWaypointsVisitedEntitiesByUserId(Long id);
    Optional<WaypointsVisitedEntity> findWaypointsVisitedEntitiesByWaypointId(Long id);
}
