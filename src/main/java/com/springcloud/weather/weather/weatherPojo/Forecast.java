package com.springcloud.weather.weather.weatherPojo;

import java.io.Serializable;

/**
 * 未来天气
 */
public class Forecast implements Serializable {
    //序列化id
    private static final long serialVersionUID = 1L;

    private String date;    //日期
    private String type;    //类型：多云
    private String high;    //高温
    private String low;     //低温
    private String fengli;      //风力
    private String fengxiang;      //风向



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }
}
