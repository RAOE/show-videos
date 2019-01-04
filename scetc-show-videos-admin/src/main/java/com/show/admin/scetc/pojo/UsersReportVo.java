package com.show.admin.scetc.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "users_report")
public class UsersReportVo {
	@Id
	private String id;

	@Column(name = "deal_user_id")
	private String dealUserId;

	@Column(name = "deal_video_id")
	private String dealVideoId;

	private String title;

	private String content;

	private String userid;

	@Column(name = "create_date")
	private Date createDate;

	private String userName;// 举报人的账户
	private String publisher;// 视频的发布者
	private String video_path;// 视频的路径
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getVideo_path() {
		return video_path;
	}

	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return deal_user_id
	 */
	public String getDealUserId() {
		return dealUserId;
	}

	/**
	 * @param dealUserId
	 */
	public void setDealUserId(String dealUserId) {
		this.dealUserId = dealUserId;
	}

	/**
	 * @return deal_video_id
	 */
	public String getDealVideoId() {
		return dealVideoId;
	}

	/**
	 * @param dealVideoId
	 */
	public void setDealVideoId(String dealVideoId) {
		this.dealVideoId = dealVideoId;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return create_date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}