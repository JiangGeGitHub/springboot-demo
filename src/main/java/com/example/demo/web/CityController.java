package com.example.demo.web;

import java.util.List;
import java.util.Map;

import com.example.demo.pojo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.City;
import com.example.demo.service.CityService;


/*
 * SpringMVC控制器
 * */
@Controller

public class CityController {

	@Autowired
	private CityService cityService;



	@Value("${adminPath}")
	private String adminPath;

	@RequestMapping(value = "${adminPath}/list", method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		List<City> cities = cityService.list();
		model.put("city", cities);
		return "lists";
	}


	@ResponseBody
	@PostMapping("${adminPath}/deleteone")
	public ResultEntity deleteStudentById(Integer id) {
		ResultEntity re=new ResultEntity();
		cityService.deleteOneById(id);


		return re;
	}

	@PostMapping("${adminPath}/addone")
	public String addStudentRestful(City city) {
		int num=cityService.addOne(city);


		return "redirect:" + adminPath + "/list";
	}


}
