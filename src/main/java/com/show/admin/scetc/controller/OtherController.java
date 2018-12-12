package com.show.admin.scetc.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.service.SettingService;
import com.show.admin.scetc.utils.ImageCodeUtils;


/**
 * @author Ray
 */
@RestController
@RequestMapping("other")
public class OtherController {

	private static final String email_smtp_host="email_smtp_host";
	private static final String email_smtp_username="email_smtp_username";
	private static final String email_smtp_password="email_smtp_password";
	private static final String email_from="email_from";
	
	@Autowired 
	private SettingService settingService;
	
	/**
	 * 图片验证码
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping("/imageCode.do")
	public void sendImageCode(HttpServletResponse response, HttpServletRequest request) {
		ImageCodeUtils.sendImageCode(request.getSession(), response);
	}
	/**
	 * 发送邮件
	 */
	@RequestMapping("/sendEmail.do")
	public void sendEmail(String email,String title,String content)
	{
		 settingService.getValueByName(email_smtp_host);
		
		 Map<String,String> emailList=new HashMap<String,String>();
        
		 
		 
		 
		 
	}
	

}
