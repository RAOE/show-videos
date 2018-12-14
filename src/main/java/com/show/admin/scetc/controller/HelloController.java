package com.show.admin.scetc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试页面
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("")
public class HelloController {
	@Value("${message}")
	private String message;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello springboot~!"+message;
	}

	@RequestMapping("welcome")
	public String welcome() {
		return "welcome to my wolrd";
	}

}
