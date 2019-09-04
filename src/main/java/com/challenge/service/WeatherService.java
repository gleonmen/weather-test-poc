package com.challenge.service;

import com.challenge.forecastRequest.RequestParametersDto;
import com.challenge.clients.APIClientFactory;
import com.challenge.clients.ClientAPIService;
import com.challenge.model.ForecastResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherService {


    @Autowired
    private HazelcastService hazelcastService;

    @Autowired
    private APIClientFactory factory;

    private ClientAPIService client;

    @HystrixCommand(fallbackMethod = "fallbackRetrieveWeather")
    public ForecastResponse checkWeather(RequestParametersDto parameters) {
        client = factory.getClientAPIService(parameters.getApiService());
        ForecastResponse response = client.getForecastFor(parameters);
        log.debug("Response {}", response);
        hazelcastService.writeData(parameters.getLatitude() + "::" + parameters.getLongitude(), response);
        log.debug("Log in Cache");
        return response;
    }

    public ForecastResponse fallbackRetrieveWeather(RequestParametersDto parameters) {
        log.debug("fall back process");
        ForecastResponse response = hazelcastService.readData(parameters.getLatitude() + "::" + parameters.getLongitude());
        log.debug("Response {}", response.toString());
        return response;
    }
}
