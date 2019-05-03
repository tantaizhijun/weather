package com.springcloud.weather.service;

import com.springcloud.weather.weatherPojo.weather.Weather;

public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
