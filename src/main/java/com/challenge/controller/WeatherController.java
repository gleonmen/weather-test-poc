package com.challenge.controller;

import com.challenge.forecastRequest.RequestParametersDto;
import com.challenge.entity.Location;
import com.challenge.model.ForecastResponse;
import com.challenge.service.HazelcastService;
import com.challenge.service.LocationService;
import com.challenge.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping(path = "v1/check-weather")
@RestController
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherService service;

    @Autowired
    private LocationService locationService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity checkWeather(@RequestParam("api-service") @Valid @NotNull String apiService,
                                       @RequestParam("city") @Valid @NotNull String city,
                                       @RequestParam("unit") @Valid @NotNull String unit) {


        Location location = locationService.getLocationByCity(city);

        RequestParametersDto parameters = RequestParametersDto.builder()
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .apiService(apiService)
                .city(city)
                .unit(unit).build();

        ForecastResponse response = service.checkWeather(parameters);
        return ResponseEntity.ok().body(response);
    }

}
