package ch.progetto152.services;

import ch.progetto152.entity.Location;
import ch.progetto152.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationByIdService(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public Location getLocationByNameService(String name){
        return locationRepository.findLocationByLocation(name).orElse(null);
    }

    public Location createLocation(Location Location) {
        return locationRepository.save(Location);
    }

    public Location updateLocation(Long id, Location Location) {
        Location location1 = getLocationByIdService(id);
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
