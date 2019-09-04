package com.challenge.service;

import com.challenge.model.ForecastResponse;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Service
@Slf4j
public class HazelcastService {


    private final HazelcastInstance hazelcastInstance;

    @Autowired
    HazelcastService(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }


    public String writeData(String key, ForecastResponse value) {
        Map<String, ForecastResponse> hazelcastMap = hazelcastInstance.getMap("my-map");
        hazelcastMap.put(key, value);
        log.debug("Data is stored.");
        return "Data is stored.";
    }


    public ForecastResponse readData(String key) {
        Map<String, ForecastResponse> hazelcastMap = hazelcastInstance.getMap("my-map");
        return hazelcastMap.get(key);
    }


}
