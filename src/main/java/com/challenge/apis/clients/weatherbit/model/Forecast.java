package com.challenge.apis.clients.weatherbit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

    @JsonProperty(value = "ts")
    private long time;
    private String summary;
    private String icon;

    @JsonProperty(value = "max_temp")
    private double temperatureMax;
    @JsonProperty(value = "min_temp")
    private double temperatureMin;
    private String datetime;
    private double temp;

    @SuppressWarnings("unchecked")
    @JsonProperty("weather")
    private void unpackWeather(Map<String, Object> weather) {
        this.summary = (String) weather.get("description");
        this.icon = (String) weather.get("icon");
    }

}
