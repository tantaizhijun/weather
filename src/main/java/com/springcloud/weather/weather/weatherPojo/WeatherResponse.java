package com.springcloud.weather.weather.weatherPojo;

import java.io.Serializable;

/**
 * 天气数据 响应体
 */
public class WeatherResponse implements Serializable {
    //序列化id
    private static final long serialVersionUID = 1L;
    private Weather data;       //天气数据
    private Integer status;     //响应状态
    private String desc;        //描述


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
