package com.challenge.apis.clients;

import com.challenge.apis.clients.darksky.DarkSkyClient;
import com.challenge.apis.clients.weatherbit.WeatherBitClient;
import com.challenge.config.ApiConfigReader;
import com.challenge.apis.clients.weatherbit.mapper.imp.WeatherBitMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class APIClientFactory {
    public static final String DARK_SKY_CLIENT = "DSC";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApiConfigReader config;

    public ClientAPIService getClientAPIService(String apiService) {
        if (apiService.equalsIgnoreCase(DARK_SKY_CLIENT)) {
            return new DarkSkyClient(restTemplate, config);
        } else {
            return new WeatherBitClient(restTemplate, config, new WeatherBitMapperImpl());
        }
    }
}
