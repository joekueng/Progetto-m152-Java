package ch.progetto152.controller;

import ch.progetto152.entity.WaypointsVisitedEntity;
import ch.progetto152.services.WaypointVisitedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class WaypointVisitedController {
    private final WaypointVisitedService waypointVisitedService;

    @Autowired
    public WaypointVisitedController(WaypointVisitedService waypointVisitedService) {
        this.waypointVisitedService = waypointVisitedService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<WaypointsVisitedEntity>> getAllWaypointsVisited() {
        List<WaypointsVisitedEntity> waypointVisited = waypointVisitedService.getAllWaypointsVisited();
        return new ResponseEntity<>(waypointVisited, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<WaypointsVisitedEntity> getWaypointVisitedById(@PathVariable("id") Long id) {
        WaypointsVisitedEntity waypointVisited = waypointVisitedService.getWaypointById(id);
        if (waypointVisited != null) {
            return new ResponseEntity<>(waypointVisited, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/name/{id}")
    public ResponseEntity<WaypointsVisitedEntity> getWaypointVisitedByUserId(@PathVariable("id") Long id) {
        WaypointsVisitedEntity waypointVisited = waypointVisitedService.getWaypointsVisitedByUserId(id);
        if (waypointVisited != null) {
            return new ResponseEntity<>(waypointVisited, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/name/{id}")
    public ResponseEntity<WaypointsVisitedEntity> getWaypointVisitedByWaypointId(@PathVariable("id") Long id) {
        WaypointsVisitedEntity waypointVisited = waypointVisitedService.getWaypointsVisitedByWaypointId(id);
        if (waypointVisited != null) {
            return new ResponseEntity<>(waypointVisited, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<WaypointsVisitedEntity> createWaypointVisited(@RequestBody WaypointsVisitedEntity waypointVisited) {
        WaypointsVisitedEntity createdWaypoint = waypointVisitedService.createWaypoint(waypointVisited);
        return new ResponseEntity<>(createdWaypoint, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<WaypointsVisitedEntity> updateWaypointVisited(@PathVariable("id") Long id, @RequestBody WaypointsVisitedEntity waypointVisited) {
        WaypointsVisitedEntity updatedWaypoint = waypointVisitedService.updateWaypoint(id, waypointVisited);
        if (updatedWaypoint != null) {
            return new ResponseEntity<>(updatedWaypoint, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWaypointVisited(@PathVariable("id") Long id) {
        boolean deleted = waypointVisitedService.deleteWaypoint(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
