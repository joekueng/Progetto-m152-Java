package ch.progetto152.controller;

import ch.progetto152.entity.Location;
import ch.progetto152.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> Locations = locationService.getAllLocations();
        return new ResponseEntity<>(Locations, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id) {
        Location location = locationService.getLocationByIdService(id);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<Location> getLocationByName(@PathVariable("name") String name) {
        Location location = locationService.getLocationByNameService(name);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createLocation(location);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable("id") Long id, @RequestBody Location location) {
        Location location1 = locationService.updateLocation(id, location);
        if (location1 != null) {
            return new ResponseEntity<>(location1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id) {
        boolean deleted = locationService.deleteLocation(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
