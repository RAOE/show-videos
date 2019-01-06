package com.show.admin.scetc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.service.SettingService;
import com.show.admin.scetc.utils.EmailUtils;
import com.show.admin.scetc.utils.ImageCodeUtils;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * @author Ray
 */
@RestController
@RequestMapping("other")
public class OtherController extends BasicController {

	private static final String email_smtp_host = "email_smtp_host";
	private static final String email_smtp_username = "email_smtp_username";
	private static final String email_smtp_password = "email_smtp_password";
	private static final String email_from = "email_from";

	@Autowired
	private SettingService settingService;// 配置文件

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
	 * 发送html格式的邮件
	 * 
	 * @return
	 */
	@PostMapping("/sendEmail.do")
	public XyfJsonResult sendEmail(String to, String subject, String content, HttpServletRequest request) {

		String smtpServer = settingService.getValueByName(email_smtp_host);
		String smtpUsername = settingService.getValueByName(email_smtp_username);
		String smtpPassword = settingService.getValueByName(email_smtp_password);
		String smtpFrom = settingService.getValueByName(email_from);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					EmailUtils.sendHtmlMail(smtpServer, smtpUsername, smtpPassword, smtpFrom, to, subject, content);
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
		}).start();
		;
		AdminUser adminUserVo = (AdminUser) request.getSession().getAttribute("adminUser");
		SimpleDateFormat formate = new SimpleDateFormat();
		String date = formate.format(new Date());
		redis.lpush(Operate_REDIS_SESSION, date + "&nbsp;&nbsp;&nbsp;" + adminUserVo.getRealName() + ":写下了一封邮件");
		return XyfJsonResult.ok();
	}

}
