package ch.progetto152.repository;

import ch.progetto152.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    Optional<LocationEntity> findLocationByLocation(String name);
}
