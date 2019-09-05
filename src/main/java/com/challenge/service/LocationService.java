package com.challenge.service;

import com.challenge.entity.Location;
import com.challenge.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    public static final String DEFAULT_CITY = "Bogota";
    @Autowired
    private LocationRepository locationRepository;

    public Location getLocationByCity(String city) {
        Location location = locationRepository.findByCity(city);
        if (location ==null){
            location = locationRepository.findByCity(DEFAULT_CITY);
        }
        return location;
    }
}
