package com.challenge.controller;

import com.challenge.dto.RequestParametersDto;
import com.challenge.entity.Location;
import com.challenge.model.ForecastResponse;
import com.challenge.service.LocationService;
import com.challenge.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api("central-weather-api")
public class CentralWeatherController {

    public static final int HTTP_OK_CODE = 200;

    private WeatherService service;
    private LocationService locationService;

    @Autowired
    public CentralWeatherController(WeatherService service, LocationService locationService) {
        this.service = service;
        this.locationService = locationService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Search a weather forecast for a city ", response = ForecastResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_OK_CODE, message = "Request created successfully", response = ForecastResponse.class)
    })
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
