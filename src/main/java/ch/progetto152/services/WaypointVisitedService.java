package ch.progetto152.services;

import ch.progetto152.entity.WaypointsVisitedEntity;
import ch.progetto152.repository.WaypointVisitedRepository;
import ch.progetto152.utility.ErrorChecking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaypointVisitedService {

    ErrorChecking errorChecking = new ErrorChecking();
    private final WaypointVisitedRepository waypointVisitedRepository;

    @Autowired
    public WaypointVisitedService(WaypointVisitedRepository waypointVisitedRepository) {
        this.waypointVisitedRepository = waypointVisitedRepository;
    }

    public List<WaypointsVisitedEntity> getAllWaypointsVisited() {
        return waypointVisitedRepository.findAll();
    }

    public WaypointsVisitedEntity getWaypointById(Long id) {
        return waypointVisitedRepository.findById(id).orElse(null);
    }

    public WaypointsVisitedEntity getWaypointsVisitedByUserId(Long id) {
        return waypointVisitedRepository.findWaypointsVisitedEntitiesByUserId(id).orElse(null);
    }

    public WaypointsVisitedEntity getWaypointsVisitedByWaypointId(Long id) {
        return waypointVisitedRepository.findWaypointsVisitedEntitiesByWaypointId(id).orElse(null);
    }

    public WaypointsVisitedEntity createWaypoint(WaypointsVisitedEntity waypoint) {
        if (errorChecking.checkWaypointVisited(waypoint)) {
            return waypointVisitedRepository.save(waypoint);
        }
        return null;
    }

    public WaypointsVisitedEntity updateWaypoint(Long id, WaypointsVisitedEntity waypoint) {
        WaypointsVisitedEntity waypoint1 = getWaypointById(id);
        if (waypoint1 != null) {
            waypoint1.setWaypointId(waypoint.getWaypointId());
            waypoint1.setUserId(waypoint.getUserId());
            return waypointVisitedRepository.save(waypoint1);
        } else {
            return null;
        }
    }

    public boolean deleteWaypoint(Long id) {
        boolean exists = waypointVisitedRepository.existsById(id);
        if (!exists) {
            return false;
        }
        waypointVisitedRepository.deleteById(id);
        return true;
    }


    public Boolean getWaypointsVisitedByWaypointIdAndUserId(Long waypointId, Long userId) {
        WaypointsVisitedEntity waypointsVisited =  waypointVisitedRepository.findWaypointsVisitedEntitiesByUserIdAndWaypointId(userId, waypointId).orElse(null);
        if (waypointsVisited != null) {
            return true;
        } else {
            return false;
        }
    }
}
