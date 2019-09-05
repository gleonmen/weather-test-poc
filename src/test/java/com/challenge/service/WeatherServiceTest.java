package com.challenge.service;

import com.challenge.apis.clients.APIClientFactory;
import com.challenge.apis.clients.darksky.DarkSkyClient;
import com.challenge.dto.RequestParametersDto;
import com.challenge.model.ForecastResponse;
import com.challenge.repository.HazelcastCache;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {


    @Mock
    private APIClientFactory factory;
    @Mock
    private HazelcastCache hazelcastCache;
    @Mock
    private DarkSkyClient darkSkyClient;


    private WeatherService weatherService;
    private RequestParametersDto parameters;


    @Before
    public void setUp() {
        weatherService = new WeatherService(hazelcastCache, factory);
        parameters = RequestParametersDto.builder()
                .latitude(4.6097100)
                .longitude(-74.0817500)
                .apiService("DSC")
                .city("Bogota")
                .unit("si").build();
    }

    @Test
    public void testCheckWeather() {
        when(factory.getClientAPIService(parameters.getApiService())).thenReturn(darkSkyClient);
        when(darkSkyClient.getForecastFor(parameters)).thenReturn(getForecastResponse(parameters));
        when(hazelcastCache.writeData(anyString(), any(ForecastResponse.class))).thenReturn("done");
        ForecastResponse response = weatherService.checkWeather(parameters);
        assertEquals(response.getLatitude(), parameters.getLatitude(),0.1);
    }

    private ForecastResponse getForecastResponse(RequestParametersDto parameters) {
        ForecastResponse forecastResponse = new ForecastResponse();
        forecastResponse.setLongitude(parameters.getLongitude());
        forecastResponse.setLatitude(parameters.getLatitude());
        return forecastResponse;
    }

}