package com.challenge.clients;

import com.challenge.forecastRequest.RequestParametersDto;
import com.challenge.model.ForecastResponse;

public interface ClientAPIService {
     ForecastResponse getForecastFor(RequestParametersDto requestParameters) ;
}
