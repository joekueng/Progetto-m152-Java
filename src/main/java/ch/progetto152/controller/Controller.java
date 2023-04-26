package ch.progetto152.controller;


import ch.progetto152.entity.Location;
import ch.progetto152.entity.User;
import ch.progetto152.entity.Waypoints;
import ch.progetto152.services.LocationService;
import ch.progetto152.services.UserService;
import ch.progetto152.services.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/progetto152", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    private static final String location = "location";
    private static final String waypoint = "waypoint";

    @Autowired
    private UserService userService;


    @GetMapping(value= location, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getLocations() {
        List<Location> locations = LocationService.getLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping(value= waypoint, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Waypoints>> getWaypoints() {
        List<Waypoints> waypoints = WaypointService.getWaypoints();
        return new ResponseEntity<>(waypoints, HttpStatus.OK);
    }

    @PostMapping(value= location, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createLocation(@RequestBody Location location) {
        LocationService.createLocation(location);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
