package com.show.admin.scetc.pojo;

/**
 * 2018.12.13 徐塬峰
 * 
 * @author Ray
 *
 */
public class MailInfo {
	// 邮箱服务器 如smtp.163.com
	private String host;
	// 用户邮箱 如**@163
	private String formName;
	// 用户授权码 不是用户名密码 可以自行查看相关邮件服务器怎么查看
	private String formPassword;
	// 消息回复邮箱
	private String replayAddress;
	// 发送地址
	private String toAddress;
	// 发送主题
	private String subject;
	// 发送内容
	private String content;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormPassword() {
		return formPassword;
	}

	public void setFormPassword(String formPassword) {
		this.formPassword = formPassword;
	}

	public String getReplayAddress() {
		return replayAddress;
	}

	public void setReplayAddress(String replayAddress) {
		this.replayAddress = replayAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
