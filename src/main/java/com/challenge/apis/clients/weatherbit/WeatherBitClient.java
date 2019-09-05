package com.challenge.apis.clients.weatherbit;


import com.challenge.apis.clients.ClientAPIService;
import com.challenge.apis.clients.weatherbit.model.ForecastDay;
import com.challenge.commons.Mapper;
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
public class WeatherBitClient implements ClientAPIService {
    public static final String FORECAST_IO_SERVICE_NAME = "ForecastIOException";

    protected static final String ARG_LATITUDE = "lat";
    protected static final String ARG_LONGITUDE = "lon";
    protected static final String UNITS = "units";
    protected static final String ARG_API_KEY = "apiKey";


    private RestTemplate restTemplate;
    private ApiConfigReader config;
    private Mapper mapper;

    public WeatherBitClient(RestTemplate restTemplate, ApiConfigReader config, Mapper assembler) {
        this.restTemplate = restTemplate;
        this.config = config;
        this.mapper = assembler;
    }

    public ForecastResponse getForecastFor(RequestParametersDto requestParameters) {

        try {
            ForecastDay forecastDay = restTemplate.getForObject(config.getWeatherbitBaseUrl(),
                    ForecastDay.class, buildURLMap(requestParameters));
            ForecastResponse response = (ForecastResponse) mapper.toModel(forecastDay);
            return response;
        } catch (HttpStatusCodeException httpStatusEx) {
            log.debug("HttpStatus from ForecastIO is: " + httpStatusEx.getRawStatusCode());
        } catch (Exception ex) {
            throw new ExternalServiceGatewayException(FORECAST_IO_SERVICE_NAME, ex);
        }
        return null;
    }

    private Map<String, String> buildURLMap(RequestParametersDto requestParameters) {
        Map<String, String> arguments = new HashMap<String, String>();
        arguments.put(ARG_API_KEY, config.getWeatherbitapikey());
        arguments.put(ARG_LONGITUDE, String.valueOf(requestParameters.getLongitude()));
        arguments.put(ARG_LATITUDE, String.valueOf(requestParameters.getLatitude()));
        arguments.put(UNITS, requestParameters.getUnit().equalsIgnoreCase("si") ? "metric" : "imperial");
        return arguments;
    }

}
