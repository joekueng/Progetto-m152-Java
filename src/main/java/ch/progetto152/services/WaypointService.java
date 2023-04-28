package ch.progetto152.services;

import ch.progetto152.entity.WaypointsEntity;
import ch.progetto152.repository.WaypointRepository;
import ch.progetto152.utility.ErrorChecking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaypointService {

    ErrorChecking errorChecking = new ErrorChecking();
    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointService(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    public List<WaypointsEntity> getAllWaypoints() {
        return waypointRepository.findAll();
    }

    public List<WaypointsEntity> getAllWaypointsByLocation(String locationName) {
        List<WaypointsEntity> waypoints = waypointRepository.findAllByLocationName(locationName);
        if (waypoints.isEmpty()) {
            return null;
        }else {
            return waypoints;
        }
    }

    public WaypointsEntity getWaypointById(Long id) {
        return waypointRepository.findById(id).orElse(null);
    }



    public WaypointsEntity createWaypoint(WaypointsEntity waypoint) {
        if (errorChecking.checkWaypoint(waypoint)) {
            return waypointRepository.save(waypoint);
        }
        return null;
    }

    public WaypointsEntity updateWaypoint(Long id, WaypointsEntity waypoint) {
        WaypointsEntity waypoint1 = getWaypointById(id);
        if (waypoint1 != null) {
            waypoint1.setName(waypoint.getName());
            waypoint1.setLat(waypoint.getLat());
            waypoint1.setLon(waypoint.getLon());
            waypoint1.setDescription(waypoint.getDescription());
            waypoint1.setImg(waypoint.getImg());
            waypoint1.setLocationName(waypoint.getLocationName());

            return waypointRepository.save(waypoint1);
        } else {
            return null;
        }
    }

    public boolean deleteWaypoint(Long id) {
        boolean exists = waypointRepository.existsById(id);
        if (!exists) {
            return false;
        }
        waypointRepository.deleteById(id);
        return true;
    }
}
