package ch.progetto152.controller;

import ch.progetto152.entity.UserEntity;
import ch.progetto152.entity.WaypointsVisitedEntity;
import ch.progetto152.services.UserService;
import ch.progetto152.services.WaypointVisitedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progetto152/waypoint/visited")
public class WaypointVisitedController {

    // Iject the WaypointVisitedService and UserService
    private final WaypointVisitedService waypointVisitedService;

    private final UserService userService;

    @Autowired
    public WaypointVisitedController(WaypointVisitedService waypointVisitedService, UserService userService) {
        this.waypointVisitedService = waypointVisitedService;
        this.userService = userService;
    }

    // Handle GET request to get all waypoints visited
    @GetMapping("")
    public ResponseEntity<List<WaypointsVisitedEntity>> getAllWaypointsVisited() {
        List<WaypointsVisitedEntity> waypointVisited = waypointVisitedService.getAllWaypointsVisited();
        return new ResponseEntity<>(waypointVisited, HttpStatus.OK);
    }

    // Handle GET request to get all waypoints visited by user
    @GetMapping("/{id}")
    public ResponseEntity<WaypointsVisitedEntity> getWaypointVisitedByWaypointId(@PathVariable("id") Long id) {
        WaypointsVisitedEntity waypointVisited = waypointVisitedService.getWaypointsVisitedByWaypointId(id);
        if (waypointVisited != null) {
            return new ResponseEntity<>(waypointVisited, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle GET request to get all waypoints visited by user
    @GetMapping("/{user}/{id}")
    public ResponseEntity<Boolean> getWaypointVisitedByWaypointIdAndUserId(@PathVariable("user") String username, @PathVariable("id") Long waypointId) {
        UserEntity user = userService.getUserByUsername(username);
        Boolean waypointVisited = waypointVisitedService.getWaypointsVisitedByWaypointIdAndUserId(waypointId, (long) user.getId());
        if (waypointVisited == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (!waypointVisited) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    // Handle GET request to get all waypoints visited by user
    @GetMapping("/user/{id}")
    public ResponseEntity<WaypointsVisitedEntity> getWaypointVisitedByUserId(@PathVariable("id") Long id) {
        WaypointsVisitedEntity waypointVisited = waypointVisitedService.getWaypointsVisitedByUserId(id);
        if (waypointVisited != null) {
            return new ResponseEntity<>(waypointVisited, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle POST request to create a new waypoint visited
    @PostMapping("")
    public ResponseEntity<WaypointsVisitedEntity> createWaypointVisited(@RequestBody WaypointsVisitedEntity waypointVisited) {
        WaypointsVisitedEntity createdWaypoint = waypointVisitedService.createWaypoint(waypointVisited);
        if(createdWaypoint == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdWaypoint, HttpStatus.CREATED);
    }

    // Handle PUT request to update a waypoint visited
    @PutMapping("/{id}")
    public ResponseEntity<WaypointsVisitedEntity> updateWaypointVisited(@PathVariable("id") Long id, @RequestBody WaypointsVisitedEntity waypointVisited) {
        WaypointsVisitedEntity updatedWaypoint = waypointVisitedService.updateWaypoint(id, waypointVisited);
        if (updatedWaypoint != null) {
            return new ResponseEntity<>(updatedWaypoint, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle DELETE request to delete a waypoint visited
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaypointVisited(@PathVariable("id") Long id) {
        boolean deleted = waypointVisitedService.deleteWaypoint(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
