package com.show.admin.scetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.show.admin.scetc.service.AdminUserService;

@Controller
@RequestMapping("")
public class IndexController {

	@Autowired 
	private AdminUserService adminUserService;
	//返回首页  
	@RequestMapping("/index")
	public String index()
	{
		return "thymeleaf/index";
	}
	@RequestMapping("/login")
	public String login()
	{
		return "thymeleaf/login";	
	}
	/**
	 * 校验用户名密码验证码
	 * @param username
	 * @param password
	 * @param verifyCode
	 * @return
	 */
	@PostMapping("loginSubmit")
	public String loginSubmit(String username,String password,String verifyCode)
	{
		
       
		
		
		return "thymeleaf/index";
	}
	
	
	
	

}
