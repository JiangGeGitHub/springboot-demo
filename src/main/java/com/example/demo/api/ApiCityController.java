package com.example.demo.api;

import com.example.demo.exception.ExistException;
import com.example.demo.pojo.City;
import com.example.demo.pojo.CityWeather;
import com.example.demo.service.CityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JIANGGE on 2019/6/11.
 * 访问地址 -http://127.0.0.1:8080/swagger-ui.html
 * 8080是项目端口号
 *
 GET（SELECT）：从服务器取出资源（一项或多项）。
 POST（CREATE）：在服务器新建一个资源。
 PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
 PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
 DELETE（DELETE）：从服务器删除资源。

 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
 204 NO CONTENT - [DELETE]：用户删除数据成功。
 *
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


    @ApiOperation(value = "根据id获取城市天气列表", notes = "根据id获取城市天气列表")
    @GetMapping(value = "${adminPath}/weatherlist")
    @ResponseStatus(HttpStatus.OK)
    public List<CityWeather> list(@RequestParam("id") int id) {
        List<CityWeather> cityWeatherList = cityService.getWeatherById(id);
        return cityWeatherList;
    }

    @ApiOperation(value = "根据id删除城市及天气历史", notes = "根据id删除城市及天气历史")
    @GetMapping(value = "${adminPath}/delweatherlist")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delweatherlist(@RequestParam("id") int id) {
        cityService.delweatherlist(id);
    }


    @ApiOperation(value = "获取单个城市", notes = "通过编号获取城市")
    @GetMapping(value = "/${adminPath}/getOneById")
    //@ResponseStatus(HttpStatus.OK)
    public Object getUser(@RequestParam("id") int id){
        City city=cityService.getOneById(id);
        return city;
    }


    @ApiOperation(value="添加城市", notes="添加城市")
    @PostMapping(value = "${adminPath}/addone")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@ApiParam(value = "名称", required = true) @RequestParam("name") String name) throws ExistException {
        City city=new City();
        city.setName(name);
        Object obj=cityService.addOne(city);
        return obj;
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
