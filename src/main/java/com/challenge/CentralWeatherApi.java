package com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableHystrix
public class CentralWeatherApi {

    public static void main(String[] args) {
        SpringApplication.run(CentralWeatherApi.class, args);
    }

}
