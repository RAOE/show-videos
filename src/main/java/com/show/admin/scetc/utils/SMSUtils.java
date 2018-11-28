package com.show.admin.scetc.utils;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * 短信验证码工具类
 */
public class SMSUtils {
	
	private static final Logger logger = Logger.getLogger(SMSUtils.class);
	private static final String SESSION_KEY_SMS_CODE = "sessionKeySMSCode";// 表示邮件验证码
	private static final String SESSION_KEY_SMS_PHONE = "986771570@qq.com";// 表示邮件收件人
	private static final String SESSION_KEY_SMS_TIME = new Date().toString();// 表示邮件发送时间
	private static final String SESSION_KEY_SMS_REMAIN_CHECK_COUNT = "3";// 表示剩余验证次数
	public static final int CHECK_RESULT_TRUE = 1;// 表示验证成功
	public static final int CHECK_RESULT_FLASE = 2;// 表示验证失败
	public static final int CHECK_RESULT_INVALID = 3;// 表示验证码失效，需要重新发送

	public static int checkSMSCode(HttpSession session, String phone, String requestCode) {
		if (phone == null || requestCode == null) {
			logger.debug("检查短信验证码失败，phone{}，requestCode：{}" + phone + requestCode);
			return CHECK_RESULT_FLASE;
		}
		String sessionPhone = (String) session.getAttribute(SESSION_KEY_SMS_PHONE);
		if (!phone.equals(sessionPhone)) {
			logger.debug("检查邮件验证码失败，phone{}，requestCode：{}，sessionPhone：{}" + phone + requestCode + sessionPhone);
			return CHECK_RESULT_FLASE;
		}
		Long sendTime = (Long) session.getAttribute(SESSION_KEY_SMS_TIME);
		// 验证码过期失效
		if (sendTime - System.currentTimeMillis() > 1000 * 60 * 30) {
			logger.debug("检查邮件验证码失败，验证码过期，phone：{}，requestCode：{}" + phone + requestCode);
			return CHECK_RESULT_INVALID;
		}

		// 如果验证码不匹配
		String sessionCode = (String) session.getAttribute(SESSION_KEY_SMS_CODE);
		Integer remainCount = (Integer) session.getAttribute(SESSION_KEY_SMS_REMAIN_CHECK_COUNT);

		if (!requestCode.equalsIgnoreCase(sessionCode)) {

			remainCount--;
			// 没有剩余验证次数了
			if (remainCount <= 0) {
				session.removeAttribute(SESSION_KEY_SMS_CODE);
				session.removeAttribute(SESSION_KEY_SMS_REMAIN_CHECK_COUNT);
				session.removeAttribute(SESSION_KEY_SMS_TIME);
				session.removeAttribute(SESSION_KEY_SMS_PHONE);
				logger.debug("检查邮件验证码失败，验证码错误，phone：{}，requestCode：{}，sessionCode：{}，remainCount：{}" + phone
						+ requestCode + sessionCode + remainCount);
				return CHECK_RESULT_INVALID;
			} else {
				session.setAttribute(SESSION_KEY_SMS_REMAIN_CHECK_COUNT, remainCount);
				logger.debug("检查邮件验证码失败，验证码错误，phone：{}，requestCode：{}，sessionCode：{}，remainCount：{}" + phone
						+ requestCode + sessionCode + remainCount);
				return CHECK_RESULT_FLASE;
			}
		}

		// 验证码匹配
		session.removeAttribute(SESSION_KEY_SMS_CODE);
		session.removeAttribute(SESSION_KEY_SMS_REMAIN_CHECK_COUNT);
		session.removeAttribute(SESSION_KEY_SMS_TIME);
		session.removeAttribute(SESSION_KEY_SMS_PHONE);

		logger.debug("检查邮件验证码成功，phone：{}，requestCode：{}，sessionCode：{}，remainCount：{}" + phone + requestCode
				+ sessionCode + remainCount);
		return CHECK_RESULT_TRUE;
	}

	@SuppressWarnings("unused")
	private static class SMSResult {
		private int code;
		private String msg;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}

	/**
	 * 产生一个四位验证码
	 * 
	 * @return
	 */
	public static int getCode() {
		Random random = new Random();
		int a = random.nextInt(8999) + 1000;
		return a;
	}

}
