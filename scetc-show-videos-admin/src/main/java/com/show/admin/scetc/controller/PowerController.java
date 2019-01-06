package com.show.admin.scetc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试页面
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/power")
public class PowerController {

	@RequestMapping("welcome")
	public String welcome() {
		return "welcome to my wolrd";
	}

}
