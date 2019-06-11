package com.example.demo.api;

import com.example.demo.pojo.City;
import com.example.demo.service.CityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by JIANGGE on 2019/6/11.
 */

@RestController
@RequestMapping("/api/")
public class ApiCityController {


    @Autowired
    private CityService cityService;


    @Value("${adminPath}")
    private String adminPath;


    /*
	ApiOperation注解中，value的值为接口说明，notes可以作为接口的简单描述。
	 */

    @ApiOperation(value = "获取城市列表", notes = "获取城市列表")
    @GetMapping(value = "${adminPath}/list")
    @ResponseStatus(HttpStatus.OK)
    public List<City> list() {
        List<City> cities = cityService.list();

        return cities;
    }


    @ApiOperation(value="添加城市", notes="添加城市")
    @PostMapping(value = "${adminPath}/addone")
    @ResponseStatus(HttpStatus.CREATED)
    public int addUser(@RequestBody City city){
        int num=cityService.addOne(city);
        return num;
    }

    @ApiOperation(value="删除城市", notes="删除城市")
    @DeleteMapping(value = "${adminPath}/deleteone")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@ApiParam(value = "编号", required = true) @RequestParam("id") String id){
        cityService.deleteOneById(Integer.parseInt(id));
    }

    @ApiOperation(value="修改城市", notes="修改城市")
    @PatchMapping(value = "${adminPath}/update")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean updateUser(@RequestBody City city){

        System.out.println("开始更新...");
        boolean flag=cityService.update(city);
        return flag;
    }

}
