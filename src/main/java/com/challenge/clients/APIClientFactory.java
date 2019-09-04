package com.challenge.clients;

import com.challenge.clients.imp.DarkSkyClient;
import com.challenge.config.ApplicationConfigReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class APIClientFactory {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplicationConfigReader config;

    public ClientAPIService getClientAPIService(String apiService){
        if(apiService.equalsIgnoreCase("DSC")){
            return new DarkSkyClient(restTemplate,config);
        } else if(apiService.equalsIgnoreCase("OTHER")){
            return null;
        }
        return null;
    }
}
