package com.challenge.service;


import com.challenge.apis.clients.APIClientFactory;
import com.challenge.apis.clients.ClientAPIService;
import com.challenge.dto.RequestParametersDto;
import com.challenge.model.ForecastResponse;
import com.challenge.repository.HazelcastCache;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherService {


    @Autowired
    private HazelcastCache hazelcastCache;

    @Autowired
    private APIClientFactory factory;

    private ClientAPIService client;
    @HystrixCommand(fallbackMethod = "fallbackRetrieveWeather", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public ForecastResponse checkWeather(RequestParametersDto parameters) {
        client = factory.getClientAPIService(parameters.getApiService());
        ForecastResponse response = client.getForecastFor(parameters);
        log.debug("Response {}", response);
        hazelcastCache.writeData(parameters.getLatitude() + "::" + parameters.getLongitude(), response);
        log.debug("Log in Cache");
        return response;
    }

    public ForecastResponse fallbackRetrieveWeather(RequestParametersDto parameters) {
        log.debug("fall back process");
        ForecastResponse response = hazelcastCache.readData(parameters.getLatitude() + "::" + parameters.getLongitude());
        log.debug("Response {}", response.toString());
        return response;
    }
}
