package com.springcloud.weather.weather.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.weather.weather.weatherPojo.WeatherResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


/**
 * 天气查询 实现类
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    //天气查询 url
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey" + cityId;
        WeatherResponse response = this.doGetWeahter(uri);
        return response;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        WeatherResponse response = this.doGetWeahter(uri);
        return response;
    }



    //抽取：请求天气数据的方法
    private WeatherResponse doGetWeahter(String uri) {
        //先查缓存
        String key = uri;
        String body = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        WeatherResponse resp = null;
        if(stringRedisTemplate.hasKey(key)) {
            logger.info("Redis has data");
            body = ops.get(key);
        } else {
            //缓存没有，再请求远程服务
            logger.info("Redis don't has data");
            if (respString.getStatusCodeValue() == 200) {
                body = respString.getBody();
            }
            //写入缓存
            ops.set(key,body,10, TimeUnit.SECONDS);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp = mapper.readValue(body, WeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }
}
