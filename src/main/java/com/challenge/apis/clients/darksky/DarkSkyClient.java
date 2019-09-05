package com.challenge.apis.clients.darksky;


import com.challenge.apis.clients.ClientAPIService;
import com.challenge.config.ApiConfigReader;
import com.challenge.dto.RequestParametersDto;
import com.challenge.exceptions.ExternalServiceGatewayException;
import com.challenge.model.ForecastResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DarkSkyClient implements ClientAPIService {


    public static final String FORECAST_IO_SERVICE_NAME = "ForecastIOException";
    protected static final String ARG_LATITUDE = "latitude";
    protected static final String ARG_LONGITUDE = "longitude";
    protected static final String ARG_API_KEY = "apiKey";
    protected static final String UNITS = "units";
    protected static final String EXCLUDE = "exclude";
    public static final String EXCLUDE_TEXT_VALUE = "minutely,hourly,alerts,flags";

    private RestTemplate restTemplate;
    private ApiConfigReader config;


    public DarkSkyClient(RestTemplate restTemplate, ApiConfigReader config) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    public ForecastResponse getForecastFor(RequestParametersDto requestParameters) {
        try {
            ForecastResponse forecast = restTemplate.getForObject(config.getDarkskyBaseUrl(),
                    ForecastResponse.class, buildURLMap(requestParameters));
            return forecast;
        } catch (HttpStatusCodeException httpStatusEx) {
            log.debug("HttpStatus from ForecastIO is: " + httpStatusEx.getRawStatusCode());
        } catch (Exception ex) {
            throw new ExternalServiceGatewayException(FORECAST_IO_SERVICE_NAME, ex);
        }
        return null;
    }

    private Map<String, String> buildURLMap(RequestParametersDto requestParameters) {
        Map<String, String> arguments = new HashMap<String, String>();
        arguments.put(ARG_API_KEY, config.getDarkskyApiKey());
        arguments.put(ARG_LONGITUDE, String.valueOf(requestParameters.getLongitude()));
        arguments.put(ARG_LATITUDE, String.valueOf(requestParameters.getLatitude()));
        arguments.put(UNITS, requestParameters.getUnit().equalsIgnoreCase("si") ? "si" : "us");
        arguments.put(EXCLUDE, EXCLUDE_TEXT_VALUE);
        return arguments;
    }

}
