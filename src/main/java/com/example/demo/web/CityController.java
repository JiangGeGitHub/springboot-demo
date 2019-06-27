package com.example.demo.web;

import com.alibaba.fastjson.JSON;
import com.example.demo.exception.ExistException;
import com.example.demo.pojo.City;
import com.example.demo.pojo.CityWeather;
import com.example.demo.pojo.ResultEntity;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/*
 * SpringMVC控制器
 * */
@Controller
//跨域处理，所有本Controller中的方法都支持来自192.168.1.97:8080的请求
@CrossOrigin(origins = "http://192.168.1.97:8080", maxAge = 3600)
public class CityController {

	@Autowired
	private CityService cityService;



	@Value("${adminPath}")
	private String adminPath;


	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "${adminPath}/list")
	//@RequestMapping(value = "${adminPath}/list", method = RequestMethod.GET)
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
	public String addStudentRestful(City city) throws ExistException {
		cityService.addOne(city);


		return "redirect:" + adminPath + "/list";
	}


	//@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@PostMapping("${adminPath}/update")
	public String updateUser( City city) {
		System.out.println("开始更新...");
		boolean flag=cityService.update(city);
		return "redirect:" + adminPath + "/list";
	}


	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "${adminPath}/viewlist")
	public String viewlist() {
		//List<CityWeather> cityWeatherList = cityService.getWeatherById(id);
		return "vueindex";
	}

	@ResponseBody
	@PostMapping (value = "${adminPath}/viewlists")
	public String viewlists() {
		Integer id=1;
		List<CityWeather> cityWeatherList = cityService.getWeatherById(1);

		String jsonStr= JSON.toJSONString(cityWeatherList);

		return jsonStr;
	}


}
