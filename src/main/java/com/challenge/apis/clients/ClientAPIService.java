package com.challenge.apis.clients;

import com.challenge.dto.RequestParametersDto;
import com.challenge.model.ForecastResponse;

public interface ClientAPIService {
    ForecastResponse getForecastFor(RequestParametersDto requestParameters);
}
