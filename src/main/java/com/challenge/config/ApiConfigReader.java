package com.challenge.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource("classpath:application.properties")
public class ApiConfigReader {
    @Value("${darksky.api.key}")
    private String darkskyApiKey;

    @Value("${darksky.base.url}")
    private String darkskyBaseUrl;

    @Value("${weatherbit.api.key}")
    private String weatherbitapikey;

    @Value("${weatherbit.base.url}")
    private String weatherbitBaseUrl;


}
