package com.show.admin.scetc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.service.SettingService;
import com.show.admin.scetc.utils.EmailUtils;
import com.show.admin.scetc.utils.ImageCodeUtils;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * @author Ray
 */
@RestController
@RequestMapping("other")
public class OtherController {

	private static final String email_smtp_host = "email_smtp_host";
	private static final String email_smtp_username = "email_smtp_username";
	private static final String email_smtp_password = "email_smtp_password";
	private static final String email_from = "email_from";
	private Logger logger = Logger.getLogger(getClass());

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
	 * 
	 * @return
	 */
	@PostMapping("/sendEmail.do")
	public XyfJsonResult sendEmail(String to, String subject, String content, HttpServletRequest request) {

//		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
//		if (adminUser == null) {
//			return XyfJsonResult.errorMsg("请返回登陆");
//		}
		
		String smtpServer = settingService.getValueByName(email_smtp_host);
		String smtpUsername = settingService.getValueByName(email_smtp_username);
		String smtpPassword = settingService.getValueByName(email_smtp_password);
		String smtpFrom = settingService.getValueByName(email_from);
		try {
			EmailUtils.sendHtmlMail(smtpServer, smtpUsername, smtpPassword, smtpFrom, to, subject, content);
		} catch (EmailException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return XyfJsonResult.ok();
	}

}
