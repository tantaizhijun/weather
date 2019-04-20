package com.springcloud.weather.weather.service;

import com.springcloud.weather.weather.weatherPojo.WeatherResponse;

/**
 * 天气查询接口
 */
public interface WeatherService {

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

}
