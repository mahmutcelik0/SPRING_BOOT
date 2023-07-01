package com.mahmutcelik.demo1.service.location;

import com.mahmutcelik.demo1.exception.LocationNotFoundException;
import com.mahmutcelik.demo1.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllUsers() throws LocationNotFoundException;

    Location getLocationById(Long id) throws LocationNotFoundException;

    Location addNewLocation(Location location);

    Location updateExistLocation(Location location, Long id) throws LocationNotFoundException;

    void deleteLocation(Long id);
}
