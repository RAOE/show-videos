package com.show.admin.scetc.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import com.show.admin.scetc.pojo.MailInfo;

public class EmailUtils {

	private static final Logger logger = Logger.getLogger(EmailUtils.class);
	private static final String SESSION_KEY_EMAIL_CODE = "sessionKeyEmailCode";// 表示邮件验证码
	private static final String SESSION_KEY_EMAIL_TO = "sessionKeyEmailTo";// 表示邮件收件人
	private static final String SESSION_KEY_EMAIL_TIME = "sessionKeyEmailTime";// 表示邮件发送时间
	private static final String SESSION_KEY_EMAIL_REMAIN_CHECK_COUNT = "sessionKeyEmailRemainCheckCount";// 表示剩余验证次数
	public static final int CHECK_RESULT_TRUE = 1;// 表示验证成功
	public static final int CHECK_RESULT_FLASE = 2;// 表示验证失败
	public static final int CHECK_RESULT_INVALID = 3;// 表示验证码失效，需要重新发送

	private EmailUtils() {
	}

	/**
	 * @param session
	 * @param requestCode
	 * @return 返回1表示验证成功；返回2表示验证失败，但还可以继续验证；返回3表示验证失败并且不能继续验证，需要重新发送邮件验证码
	 */
	public static int checkEmailCode(HttpSession session, String email, String requestCode) {
		if (email == null || requestCode == null) {
			logger.debug("检查邮件验证码失败，email：{}，requestCode：{}");
			return CHECK_RESULT_FLASE;
		}
		String sessionEmail = (String) session.getAttribute(SESSION_KEY_EMAIL_TO);
		if (!email.equals(sessionEmail)) {
			logger.debug("检查邮件验证码失败，用户填写的邮箱和验证码发送的邮箱不一致，email：{}，requestCode：{}，sessionEmail：{}");
			return CHECK_RESULT_FLASE;
		}
		Long sendTime = (Long) session.getAttribute(SESSION_KEY_EMAIL_TIME);
		// 验证码过期失效
		if (sendTime - System.currentTimeMillis() > 1000 * 60 * 30) {
			logger.debug("检查邮件验证码失败，验证码过期，email{}，requestCode：{}");
			return CHECK_RESULT_INVALID;
		}

		// 如果验证码不匹配
		String sessionCode = (String) session.getAttribute(SESSION_KEY_EMAIL_CODE);
		Integer remainCount = (Integer) session.getAttribute(SESSION_KEY_EMAIL_REMAIN_CHECK_COUNT);

		if (!requestCode.equalsIgnoreCase(sessionCode)) {

			remainCount--;
			// 没有剩余验证次数了
			if (remainCount <= 0) {
				session.removeAttribute(SESSION_KEY_EMAIL_CODE);
				session.removeAttribute(SESSION_KEY_EMAIL_REMAIN_CHECK_COUNT);
				session.removeAttribute(SESSION_KEY_EMAIL_TIME);
				session.removeAttribute(SESSION_KEY_EMAIL_TO);
				logger.debug("检查邮件验证码失败，验证码错误，email：{}，requestCode：{}，sessionCode：{}，remainCount：{}");
				return CHECK_RESULT_INVALID;
			} else {
				session.setAttribute(SESSION_KEY_EMAIL_REMAIN_CHECK_COUNT, remainCount);
				logger.debug("检查邮件验证码失败，验证码错误，email：{}，requestCode：{}，sessionCode：{}，remainCount：{}");
				return CHECK_RESULT_FLASE;
			}
		}
		// 验证码匹配
		session.removeAttribute(SESSION_KEY_EMAIL_CODE);
		session.removeAttribute(SESSION_KEY_EMAIL_REMAIN_CHECK_COUNT);
		session.removeAttribute(SESSION_KEY_EMAIL_TIME);
		session.removeAttribute(SESSION_KEY_EMAIL_TO);

		logger.debug("检查邮件验证码成功，email：{}，requestCode：{}，sessionCode：{}，remainCount：{}");
		return CHECK_RESULT_TRUE;
	}

	// 发送邮件验证码
	public static void sendEmailCode(HttpSession session, String smtpServer, String username, String password,
			String from, String to) {

		String subject = "邮箱验证码 - 秀视频";
		// 得到一个随机的5位数字的验证码
		String emailCode = new Random().nextInt(90000) + 10000 + "";
		String content = "您的邮箱验证码是：" + emailCode + "（30分钟内有效）";

		try {
			sendEmail(smtpServer, username, password, from, to, subject, content);
			session.setAttribute(SESSION_KEY_EMAIL_CODE, emailCode);
			session.setAttribute(SESSION_KEY_EMAIL_TO, to);
			session.setAttribute(SESSION_KEY_EMAIL_TIME, System.currentTimeMillis());
			session.setAttribute(SESSION_KEY_EMAIL_REMAIN_CHECK_COUNT, 5);// 一个邮件验证码默认可验证5次，5此后就需要重新发送验证码
			logger.debug("发送邮件验证码成功，email：{}，code：{}");
		} catch (Exception e) {
			logger.debug("发送邮件验证码失败，email：{}，code：{}");
			throw new RuntimeException("发送邮箱验证码失败", e);
		}
	}

	public static void sendEmail(String smtpServer, String username, String password, String from, String to,
			String subject, String content) throws EmailException {
		HtmlEmail email = new HtmlEmail();// 发送html格式邮件
		email.setHostName(smtpServer);
		email.setCharset("UTF-8");
		email.setAuthentication(username, password);
		email.setFrom(from);
		email.addTo(to);
		email.setSubject(subject);
		email.setMsg(content);
		email.send();
	}

	/**
	 * 发送html格式的邮件数据
	 * 
	 * @param info
	 * @throws Exception
	 */
	public static void sendHtmlMail(String smtpServer, String username, String password, String from, String to,
			String subject, String content) throws Exception {

		MailInfo info = new MailInfo();
		info.setHost(smtpServer);
		info.setFormName(username);
		info.setFormPassword(password);
		info.setReplayAddress(from);
		info.setToAddress(to);
		info.setSubject(subject);
		info.setContent(content);
		Message message = getMessage(info);
		// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart mainPart = new MimeMultipart();
		// 创建一个包含HTML内容的MimeBodyPart
		BodyPart html = new MimeBodyPart();
		// 设置HTML内容
		html.setContent(info.getContent(), "text/html; charset=utf-8");
		mainPart.addBodyPart(html);
		// 将MiniMultipart对象设置为邮件内容
		message.setContent(mainPart);
		Transport.send(message);
	}

	// 使用sendcloud发送验证码邮件
	public static void sendEmailCodeWithSendCloud(HttpSession session, String url, String apiUser, String apiKey,
			String from, String to, String templateInvokeName) {

		// 得到一个随机的5位数字的验证码
		String emailCode = new Random().nextInt(90000) + 10000 + "";

		Map<String, String> params = new HashMap<String, String>();
		params.put("apiUser", apiUser);
		params.put("apiKey", apiKey);
		params.put("from", from);
		params.put("templateInvokeName", templateInvokeName);

		Map<String, Object> xsmtpapiMap = new HashMap<String, Object>();
		xsmtpapiMap.put("to", new String[] { to });

		Map<String, Object> subMap = new HashMap<String, Object>();
		subMap.put("%code%", new String[] { emailCode });

		xsmtpapiMap.put("sub", subMap);

		params.put("xsmtpapi", JsonUtils.toJson(xsmtpapiMap));

		try {

			String result = HttpUtils.post(url, params);
			Pattern pattern = Pattern.compile("\"result\" *: *true");
			if (!pattern.matcher(result).find()) {
				throw new RuntimeException("发送邮件失败，响应信息为：" + result);
			}

			session.setAttribute(SESSION_KEY_EMAIL_CODE, emailCode);
			session.setAttribute(SESSION_KEY_EMAIL_TO, to);
			session.setAttribute(SESSION_KEY_EMAIL_TIME, System.currentTimeMillis());
			session.setAttribute(SESSION_KEY_EMAIL_REMAIN_CHECK_COUNT, 5);// 一个邮件验证码默认可验证5次，5此后就需要重新发送验证码
			logger.debug("发送邮件验证码成功，email：{}，code：{}");
		} catch (Exception e) {
			logger.debug("发送邮件验证码失败，email：{}，code：{}");
			throw new RuntimeException("发送邮箱验证码失败", e);
		}
	}

	private static Message getMessage(MailInfo info) throws Exception {
		final Properties p = System.getProperties();
		p.setProperty("mail.smtp.host", info.getHost());
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.user", info.getFormName());
		p.setProperty("mail.smtp.pass", info.getFormPassword());
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session session = Session.getInstance(p, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(p.getProperty("mail.smtp.user"), p.getProperty("mail.smtp.pass"));
			}
		});
		session.setDebug(true);
		Message message = new MimeMessage(session);
		// 消息发送的主题
		message.setSubject(info.getSubject());
		// 接受消息的人
		message.setReplyTo(InternetAddress.parse(info.getReplayAddress()));
		// 消息的发送者
		message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"), "徐塬峰"));
		// 创建邮件的接收者地址，并设置到邮件消息中
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(info.getToAddress()));
		// 消息发送的时间
		message.setSentDate(new Date());
		return message;
	}

}