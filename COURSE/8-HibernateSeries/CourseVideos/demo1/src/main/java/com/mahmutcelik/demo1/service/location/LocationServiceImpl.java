package com.mahmutcelik.demo1.service.location;

import com.mahmutcelik.demo1.exception.LocationNotFoundException;
import com.mahmutcelik.demo1.model.Location;
import com.mahmutcelik.demo1.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllUsers() throws LocationNotFoundException {
        List<Location> tempVal = locationRepository.findAll();
        if(tempVal.size()>0) return tempVal;
        throw new LocationNotFoundException();
    }

    @Override
    public Location getLocationById(Long id) throws LocationNotFoundException {
        return locationRepository.findById(id).orElseThrow(LocationNotFoundException::new);
    }

    @Override
    public Location addNewLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateExistLocation(Location location, Long id) throws LocationNotFoundException {
        return locationRepository.findById(id).map(e -> locationRepository.save(location)).orElseThrow(LocationNotFoundException::new);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
