package com.example.demo.mapper;

import com.example.demo.pojo.City;
import com.example.demo.pojo.CityWeather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Mapper接口，这里需要加上Mapper注解
 */
@Mapper
public interface CityWeatherMapper {

    List<CityWeather> getWeatherById(@Param("id")int id);

}
