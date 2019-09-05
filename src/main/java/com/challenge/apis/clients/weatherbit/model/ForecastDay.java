package com.challenge.apis.clients.weatherbit.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {
    @JsonProperty(value = "lat")
    private double latitude;
    @JsonProperty(value = "lon")
    private double longitude;
    private List<Forecast> data;
}
