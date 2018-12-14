package com.show.admin.scetc.pojo;

import java.util.List;

/**
 * 页面初始化实体类
 * 
 * @author Ray
 *
 */
public class Bootstrap {

	private int videoNum;
	private int userNum;
	private int activeUserNum;

	private List<String> logList;
	private List<String> messageList;
	private List<String> userMessageList;
	private List<String> userLocalList;

	public int getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getActiveUserNum() {
		return activeUserNum;
	}

	public void setActiveUserNum(int activeUserNum) {
		this.activeUserNum = activeUserNum;
	}

	public List<String> getLogList() {
		return logList;
	}

	public void setLogList(List<String> logList) {
		this.logList = logList;
	}

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

	public List<String> getUserMessageList() {
		return userMessageList;
	}

	public void setUserMessageList(List<String> userMessageList) {
		this.userMessageList = userMessageList;
	}

	public List<String> getUserLocalList() {
		return userLocalList;
	}

	public void setUserLocalList(List<String> userLocalList) {
		this.userLocalList = userLocalList;
	}

	@Override
	public String toString() {
		return "Bootsrap [videoNum=" + videoNum + ", userNum=" + userNum + ", activeUserNum=" + activeUserNum
				+ ", logList=" + logList + ", messageList=" + messageList + ", userMessageList=" + userMessageList
				+ ", userLocalList=" + userLocalList + "]";
	}

}
