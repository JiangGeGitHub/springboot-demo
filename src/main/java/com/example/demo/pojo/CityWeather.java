package com.example.demo.pojo;


import java.util.Date;

/**
 * Created by JIANGGE on 2019/6/11.
 */
public class CityWeather {

    private Integer cityId;
    private String weather;
    private Date date;
    private String name;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
