package com.example.demo.web;

import com.example.demo.exception.ExistException;
import com.example.demo.pojo.City;
import com.example.demo.pojo.ResultEntity;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;


/*
 * SpringMVC控制器
 * */
@Controller
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


}
