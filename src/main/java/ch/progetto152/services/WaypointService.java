package ch.progetto152.services;

import ch.progetto152.entity.WaypointsEntity;
import ch.progetto152.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaypointService {
    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointService(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    public List<WaypointsEntity> getAllWaypoints() {
        return waypointRepository.findAll();
    }

    public WaypointsEntity getWaypointById(Long id) {
        return waypointRepository.findById(id).orElse(null);
    }

    public WaypointsEntity getWaypointByName(String name) {
        return waypointRepository.findWaypointByName(name).orElse(null);
    }

    public WaypointsEntity createWaypoint(WaypointsEntity waypoint) {
        return waypointRepository.save(waypoint);
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
