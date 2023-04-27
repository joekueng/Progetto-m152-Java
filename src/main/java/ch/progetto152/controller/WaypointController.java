package ch.progetto152.controller;

import ch.progetto152.entity.Waypoints;
import ch.progetto152.services.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waypoints")
public class WaypointController {
    private final WaypointService waypointService;

    @Autowired
    public WaypointController(WaypointService waypointService) {
        this.waypointService = waypointService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Waypoints>> getAllWaypoints() {
        List<Waypoints> waypoint = waypointService.getAllWaypoints();
        return new ResponseEntity<>(waypoint, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Waypoints> getWaypointById(@PathVariable("id") Long id) {
        Waypoints waypoint = waypointService.getWaypointByIdService(id);
        if (waypoint != null) {
            return new ResponseEntity<>(waypoint, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<Waypoints> getWaypointByName(@PathVariable("name") String name) {
        Waypoints waypoint = waypointService.getWaypointByNameService(name);
        if (waypoint != null) {
            return new ResponseEntity<>(waypoint, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Waypoints> createWaypoint(@RequestBody Waypoints waypoint) {
        Waypoints createdWaypoint = waypointService.createWaypoint(waypoint);
        return new ResponseEntity<>(createdWaypoint, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Waypoints> updateWaypoint(@PathVariable("id") Long id, @RequestBody Waypoints waypoint) {
        Waypoints updatedWaypoint = waypointService.updateWaypoint(id, waypoint);
        if (updatedWaypoint != null) {
            return new ResponseEntity<>(updatedWaypoint, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWaypoint(@PathVariable("id") Long id) {
        boolean deleted = waypointService.deleteWaypoint(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
