package com.challenge.apis.clients.weatherbit.mapper.imp;

import com.challenge.apis.clients.weatherbit.mapper.WeatherBitMapper;
import com.challenge.apis.clients.weatherbit.model.Forecast;
import com.challenge.apis.clients.weatherbit.model.ForecastDay;
import com.challenge.commons.BaseMapper;
import com.challenge.model.CurrentForecast;
import com.challenge.model.DailyForecast;
import com.challenge.model.DailyForecastData;
import com.challenge.model.ForecastResponse;

import java.util.ArrayList;
import java.util.List;

public class WeatherBitMapperImpl extends BaseMapper<ForecastDay, ForecastResponse> implements WeatherBitMapper {
    @Override
    public ForecastDay toDto(ForecastResponse model) {
        return null;
    }

    @Override
    public ForecastResponse toModel(ForecastDay dto) {
        ForecastResponse response = getForecastResponse(dto);
        CurrentForecast current = getCurrentForecast(dto);
        DailyForecast dailyForecast = getDailyForecast(dto);
        response.setCurrently(current);
        response.setDaily(dailyForecast);
        return response;
    }

    private DailyForecast getDailyForecast(ForecastDay dto) {
        DailyForecast dailyForecast = new DailyForecast();
        List<DailyForecastData> list = new ArrayList<>();
        for (Forecast forecast : dto.getData()) {
            list.add(toDailyForecastDataModel(forecast));
        }
        dailyForecast.setData(list);
        return dailyForecast;
    }

    private ForecastResponse getForecastResponse(ForecastDay dto) {
        ForecastResponse response = new ForecastResponse();
        response.setLatitude(dto.getLatitude());
        response.setLongitude(dto.getLongitude());
        return response;
    }

    private CurrentForecast getCurrentForecast(ForecastDay dto) {
        CurrentForecast current = new CurrentForecast();
        Forecast today = dto.getData().get(0);
        if (today != null) {
            current.setTemperature(today.getTemp());
            current.setIcon(today.getIcon());
            current.setSummary(today.getSummary());
            current.setTime(today.getTime());
        }
        return current;
    }

    private DailyForecastData toDailyForecastDataModel(Forecast forecast) {
        DailyForecastData response = new DailyForecastData();
        response.setTemperatureMax(forecast.getTemperatureMax());
        response.setTemperatureMin(forecast.getTemperatureMin());
        response.setIcon(forecast.getIcon());
        response.setSummary(forecast.getSummary());
        response.setTime(forecast.getTime());
        return response;
    }
}
