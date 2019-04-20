package com.springcloud.weather.weather.weatherPojo;

import java.io.Serializable;

/**
 * 昨日的天气
 */
public class Yesterday implements Serializable {

    //序列化id
    private static final long serialVersionUID = 1L;
    private String date;    //日期
    private String type;    //天气类型：多云
    private String high;    //高温
    private String low;     //低温
    private String fx;      //风向
    private String fl;      //风力


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public Yesterday() {
        super();
    }
}
