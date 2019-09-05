package com.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class ForecastResponse {

    private double longitude;
    private double latitude;
    private CurrentForecast currently;
    private DailyForecast daily;

}
