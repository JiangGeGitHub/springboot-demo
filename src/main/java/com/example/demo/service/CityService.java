package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.mapper.CityMapper;
import com.example.demo.pojo.City;
import org.springframework.util.CollectionUtils;


/*
 * 服务层
 * */
@Service
public class CityService {

	@Autowired
	private CityMapper cityMapper;
	
	
	public List<City> list(){
		return cityMapper.selectAll();
	}


    public void deleteOneById(Integer id) {
		cityMapper.deleteOneById(id);
    }

    public Object addOne(City city){

		List<City> cityList = cityMapper.getOneByName(city.getName());
		if (!CollectionUtils.isEmpty(cityList)){
			return new Result("城市【" + city.getName() + "】已经存在",
					Result.ErrorCode.USER_ALREADY_EXIST.getCode());
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
