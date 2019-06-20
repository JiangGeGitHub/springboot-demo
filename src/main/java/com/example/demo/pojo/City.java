package com.example.demo.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * City实体类
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
// 需要实现序列化接口
public class City implements Serializable {
	
	private Integer id;
	
	
	private String name;


}
