package com.challenge.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource("classpath:application.properties")
public class ApplicationConfigReader {
    @Value("${darksky.api.key}")
    private String darkskyApiKey;

    @Value("${darksky.base.url}")
    private String darkskyBaseUrl;

}
