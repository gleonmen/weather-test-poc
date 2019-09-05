package com.challenge.config;


import com.challenge.apis.clients.APIClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GeneralConfig {

    @Autowired
    private ApiConfigReader applicationConfig;

    @Bean
    public APIClientFactory apiClientFactory() {
        return new APIClientFactory();
    }

    @Bean
    public ApiConfigReader applicationConfig() {
        return new ApiConfigReader();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
