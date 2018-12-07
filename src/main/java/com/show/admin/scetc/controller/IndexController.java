package com.show.admin.scetc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.utils.XyfJsonResult;

@Controller
@RequestMapping("")
public class IndexController {

	// 返回首页
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {

		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
		request.setAttribute("adminUser", adminUser);
		
		return "thymeleaf/index";
	}

	// 500 错误页面
	@RequestMapping("/500")
	public String errorPage() {
		return "thymeleaf/500";
	}

	// 404 页面
	@RequestMapping("/404")
	public String notFoundPage() {
		return "thymeleaf/404";
	}

	@PostMapping("/test")
	public XyfJsonResult test()
	{
		return XyfJsonResult.ok("请求成功");
	}
	
	
}
