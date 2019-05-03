package com.springcloud.weather.service;

import com.springcloud.weather.weatherPojo.weather.Weather;
import com.springcloud.weather.weatherPojo.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherService  weatherService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherService.getDataByCityId(cityId);
        return resp.getData();
    }
}
