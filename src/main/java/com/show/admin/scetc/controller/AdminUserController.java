package com.show.admin.scetc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.service.AdminUserService;
import com.show.admin.scetc.utils.ImageCodeUtils;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

	// 返回首页
	@Autowired
	private AdminUserService adminUserService;

	//注销操作
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		request.getSession().invalidate();//销毁session 中的数据
		return "thymeleaf/login";
	}
	//注销操作
	@RequestMapping("/forgetPassword.do")
	public String forgetPassword(HttpServletRequest request,HttpServletResponse response) {
		
		return "thymeleaf/forgetPassword";
	}
	
	@RequestMapping("/login")
	public String login() {
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
	public String loginSubmit(HttpServletRequest request,String username, String password, String verifyCode
			,Model model) {

		
		if (!ImageCodeUtils.checkImageCode(request.getSession(), verifyCode)) {
		    model.addAttribute("message","验证码输入错误");
			return "thymeleaf/login";
		}
		// 尝试登陆操作
		AdminUser adminUser = adminUserService.login(username, password);
		if (adminUser == null) {
			//登陆失败
			model.addAttribute("message","账号密码错误");
			return "thymeleaf/login";
		}
		//检查账号是否被禁用了
		
		//登陆成功
        request.getSession().setAttribute("adminUser", adminUser);//将账号密码添加到session 中
		return "thymeleaf/index";
	}

}
