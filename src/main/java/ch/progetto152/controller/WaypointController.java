package ch.progetto152.controller;

import ch.progetto152.entity.WaypointsEntity;
import ch.progetto152.services.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progetto152/waypoint")
public class WaypointController {
    private final WaypointService waypointService;

    @Autowired
    public WaypointController(WaypointService waypointService) {
        this.waypointService = waypointService;
    }

    @GetMapping("")
    public ResponseEntity<List<WaypointsEntity>> getAllWaypoints() {
        List<WaypointsEntity> waypoint = waypointService.getAllWaypoints();
        return new ResponseEntity<>(waypoint, HttpStatus.OK);
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<WaypointsEntity>> getAllWaypoints(@PathVariable("location") String location) {
        System.out.println(waypointService.getAllWaypointsByLocation(location));
        List<WaypointsEntity> waypoint = waypointService.getAllWaypointsByLocation(location);
        return new ResponseEntity<>(waypoint, HttpStatus.OK);
    }

    @GetMapping("/{location}/{id}")
    public ResponseEntity<WaypointsEntity> getWaypoint(@PathVariable("location") String location, @PathVariable("id") Long id) {
        WaypointsEntity waypoint = waypointService.getWaypointById(id);
        if (waypoint != null) {
            if (waypoint.getLocationName().equals(location)) {
                return new ResponseEntity<>(waypoint, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<WaypointsEntity> getWaypointById(@PathVariable("id") Long id) {
        WaypointsEntity waypoint = waypointService.getWaypointById(id);
        if (waypoint != null) {
            return new ResponseEntity<>(waypoint, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<WaypointsEntity> createWaypoint(@RequestBody WaypointsEntity waypoint) {
        WaypointsEntity createdWaypoint = waypointService.createWaypoint(waypoint);
        if (createdWaypoint == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdWaypoint, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaypointsEntity> updateWaypoint(@PathVariable("id") Long id, @RequestBody WaypointsEntity waypoint) {
        WaypointsEntity updatedWaypoint = waypointService.updateWaypoint(id, waypoint);
        if (updatedWaypoint != null) {
            return new ResponseEntity<>(updatedWaypoint, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaypoint(@PathVariable("id") Long id) {
        boolean deleted = waypointService.deleteWaypoint(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
