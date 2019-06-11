package com.example.demo.service;

import com.example.demo.exception.ExistException;
import com.example.demo.exception.Result;
import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.CityWeatherMapper;
import com.example.demo.pojo.City;
import com.example.demo.pojo.CityWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/*
 * 服务层
 * */
@Service
public class CityService {

	@Autowired
	private CityMapper cityMapper;


	@Autowired
	private CityWeatherMapper cityWeatherMapper;



	public List<CityWeather> getWeatherById(Integer id){
		List<CityWeather> lsit=cityWeatherMapper.getWeatherById(id);
		return lsit;
	}
	
	public List<City> list(){
		return cityMapper.selectAll();
	}


    public void deleteOneById(Integer id) {
		cityMapper.deleteOneById(id);
    }

    public Object addOne(City city) throws ExistException {

		List<City> cityList = cityMapper.getOneByName(city.getName());

		if (!CollectionUtils.isEmpty(cityList)){
			throw new ExistException("城市【" + city.getName() + "】已经存在", Result.ErrorCode.USER_NOT_FOUND.getCode());
		}

		 return cityMapper.addOne(city);
	}

	public boolean update(City city) {
		return cityMapper.update(city);
	}

	public City getOneById(int id) {
    	return cityMapper.getOneById(id);
	}
}
