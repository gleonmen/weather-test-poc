package com.challenge.forecastRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestParametersDto {
    private double latitude;
    private double longitude;
    private String unit;
    private String apiService;
    private String city;
}
