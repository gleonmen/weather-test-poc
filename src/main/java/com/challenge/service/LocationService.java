package com.challenge.service;

import com.challenge.entity.Location;
import com.challenge.repository.LocationRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location getLocationByCity(String city) {
        return locationRepository.findByCity(city);
    }
}
