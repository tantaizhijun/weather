package com.springcloud.weather.weatherPojo.weather;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息
 */
public class Weather implements Serializable {
    //序列化id
    private static final long serialVersionUID = 1L;

    private String city;                //城市
    private String aqi;                 //空气质量指数
    private String ganmao;              //保暖提示
    private String wendu;               //温度
    private Yesterday yesterday;        //昨日天气
    private List<Forecast> forecast;    //未来天气


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
