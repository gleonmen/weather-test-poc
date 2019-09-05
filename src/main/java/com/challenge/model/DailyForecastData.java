package com.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class DailyForecastData extends ForecastBase {
    private double temperatureMin;
    private double temperatureMax;
}
