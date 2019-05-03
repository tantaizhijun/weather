package com.springcloud.weather.service;

import com.springcloud.weather.weatherPojo.city.City;

import java.util.List;

public interface CityDataService {

    List<City> listCity() throws Exception;
}
