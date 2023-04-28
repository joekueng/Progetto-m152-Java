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
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("")
    public ResponseEntity<List<LocationEntity>> getAllLocations() {
        List<LocationEntity> Locations = locationService.getAllLocations();
        return new ResponseEntity<>(Locations, HttpStatus.OK);
    }


    @GetMapping("/{name}")
    public ResponseEntity<LocationEntity> getLocationByName(@PathVariable("name") String name) {
        LocationEntity location = locationService.getLocationByName(name);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<LocationEntity> getLocationById(@PathVariable("id") Long id) {
        LocationEntity location = locationService.getLocationById(id);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<LocationEntity> createLocation(@RequestBody LocationEntity location) {
        LocationEntity createdLocation = locationService.createLocation(location);
        if(createdLocation == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationEntity> updateLocation(@PathVariable("id") Long id, @RequestBody LocationEntity location) {
        LocationEntity location1 = locationService.updateLocation(id, location);
        if (location1 != null) {
            return new ResponseEntity<>(location1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id) {
        boolean deleted = locationService.deleteLocation(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
