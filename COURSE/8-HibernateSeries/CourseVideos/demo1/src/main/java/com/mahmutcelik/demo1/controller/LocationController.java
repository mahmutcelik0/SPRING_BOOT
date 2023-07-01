package com.mahmutcelik.demo1.controller;

import com.mahmutcelik.demo1.exception.LocationNotFoundException;
import com.mahmutcelik.demo1.model.Location;
import com.mahmutcelik.demo1.model.User;
import com.mahmutcelik.demo1.service.location.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    private List<Location> getAllUsers() throws LocationNotFoundException {
        return locationService.getAllUsers();
    }

    @GetMapping("/location/{id}")
    private Location getLocationById(@PathVariable Long id) throws LocationNotFoundException {
        return locationService.getLocationById(id);
    }

    @GetMapping("/location/{id}/users")
    private List<User> getUsersOfLocation(@PathVariable Long id) throws LocationNotFoundException {
        return getLocationById(id).getUsers();
    }

    @PostMapping("/location")
    private Location addNewLocation(@RequestBody Location location){
        return locationService.addNewLocation(location);
    }

    @PutMapping("/location/{id}")
    private Location updateExistLocation(@PathVariable("id") Long id,@RequestBody Location location) throws LocationNotFoundException {
        return locationService.updateExistLocation(location,id);
    }

    @DeleteMapping("/location/{id}")
    private void deleteLocation(@PathVariable("id") Long id){
        locationService.deleteLocation(id);
    }
}
