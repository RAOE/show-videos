package com.show.admin.scetc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试页面
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("")
public class HelloController {

	@RequestMapping("welcome")
	public String welcome() {
		return "welcome to my wolrd";
	}

	@RequestMapping("test.do")
	public ModelAndView modelAndView() {
		return new ModelAndView("index.html");
	}

}
