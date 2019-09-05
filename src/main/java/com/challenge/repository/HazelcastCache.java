package com.challenge.repository;

import com.challenge.model.ForecastResponse;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class HazelcastCache {


    private final HazelcastInstance hazelcastInstance;

    @Autowired
    HazelcastCache(HazelcastInstance hazelcastInstance) {
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
