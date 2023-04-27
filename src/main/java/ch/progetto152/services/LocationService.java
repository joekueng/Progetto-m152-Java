package ch.progetto152.services;

import ch.progetto152.entity.LocationEntity;
import ch.progetto152.repository.LocationRepository;
import ch.progetto152.utility.ErrorChecking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private ErrorChecking errorChecking = new ErrorChecking();
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }

    public LocationEntity getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public LocationEntity getLocationByName(String name){
        return locationRepository.findLocationByLocation(name).orElse(null);
    }

    public LocationEntity createLocation(LocationEntity Location) {
        if(errorChecking.checkLocation(Location)) {
            return locationRepository.save(Location);
        } else {
            return null;
        }
    }

    public LocationEntity updateLocation(Long id, LocationEntity Location) {
        LocationEntity location1 = getLocationById(id);
        if (location1 != null) {
            location1.setLocation(Location.getLocation());
            location1.setRegion(Location.getRegion());
            location1.setLat(Location.getLat());
            location1.setLon(Location.getLon());
            return locationRepository.save(location1);
        } else {
            return null;
        }
    }

    public boolean deleteLocation(Long id) {
        boolean exists = locationRepository.existsById(id);
        if(!exists){
            return false;
        }
        locationRepository.deleteById(id);
        return true;
    }
}
