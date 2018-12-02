package com.show.admin.scetc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {

	// 返回首页
	@RequestMapping("/index")
	public String index() {
		return "thymeleaf/index";
	}

	// 返回首页
	@RequestMapping("/500")
	public String errorPage() {
		return "thymeleaf/500";
	}

	// 返回首页
	@RequestMapping("/404")
	public String notFoundPage() {
		return "thymeleaf/404";
	}

}
