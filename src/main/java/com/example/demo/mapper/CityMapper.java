package com.example.demo.mapper;

import com.example.demo.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Mapper接口，这里需要加上Mapper注解
 */
@Mapper
public interface CityMapper {
	
	List<City> selectAll();

    int deleteOneById(@Param("id") Integer id);

    int addOne( City city);


    boolean update(City city);

    City  getOneById(@Param("id")int id);

    List<City> getOneByName(@Param("name")String name);
}
