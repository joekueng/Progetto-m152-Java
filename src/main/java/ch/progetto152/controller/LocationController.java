package ch.progetto152.controller;

import ch.progetto152.entity.LocationEntity;
import ch.progetto152.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progetto152/location")
public class LocationController {

    // Inject the LocationService
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // Handle GET request to get all locations
    @GetMapping("")
    public ResponseEntity<List<LocationEntity>> getAllLocations() {
        List<LocationEntity> Locations = locationService.getAllLocations();
        return new ResponseEntity<>(Locations, HttpStatus.OK);
    }

    // Handle GET request to get a specific location by name
    @GetMapping("/{name}")
    public ResponseEntity<LocationEntity> getLocationByName(@PathVariable("name") String name) {
        LocationEntity location = locationService.getLocationByName(name);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle POST request to create a new location
    @PostMapping("")
    public ResponseEntity<LocationEntity> createLocation(@RequestBody LocationEntity location) {
        LocationEntity createdLocation = locationService.createLocation(location);
        if (createdLocation == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    // Handle PUT request to update an existing location
    @PutMapping("/{name}")
    public ResponseEntity<LocationEntity> updateLocation(@PathVariable("name") String name, @RequestBody LocationEntity location) {
        LocationEntity location1 = locationService.updateLocation(name, location);
        if (location1 != null) {
            return new ResponseEntity<>(location1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle DELETE request to delete an existing location by name
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("name") String name) {
        boolean deleted = locationService.deleteLocation(name);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
