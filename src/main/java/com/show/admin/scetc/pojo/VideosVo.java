package com.show.admin.scetc.pojo;

import java.util.Date;

/**
 * 关联查询 返回结果
 * 
 * @author Ray
 *
 */
public class VideosVo {
	private String id;

	private String userId;

	private String audioId;

	private String videoDesc;

	private String videoPath;

	private String videoCategory;

	private Float videoSeconds;

	private Integer videoWidth;

	private Integer videoHeight;

	private String coverPath;

	private Long likeCounts;

	private Integer status;

	private Date createTime;

	private String nickName;

	private String face_image;

	private String videoFilter;

	public String getVideoFilter() {
		return videoFilter;
	}

	public void setVideoFilter(String videoFilter) {
		this.videoFilter = videoFilter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAudioId() {
		return audioId;
	}

	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}

	public String getVideoDesc() {
		return videoDesc;
	}

	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public Float getVideoSeconds() {
		return videoSeconds;
	}

	public void setVideoSeconds(Float videoSeconds) {
		this.videoSeconds = videoSeconds;
	}

	public Integer getVideoWidth() {
		return videoWidth;
	}

	public void setVideoWidth(Integer videoWidth) {
		this.videoWidth = videoWidth;
	}

	public Integer getVideoHeight() {
		return videoHeight;
	}

	public void setVideoHeight(Integer videoHeight) {
		this.videoHeight = videoHeight;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public Long getLikeCounts() {
		return likeCounts;
	}

	public void setLikeCounts(Long likeCounts) {
		this.likeCounts = likeCounts;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}

	public String getFace_image() {
		return face_image;
	}

	public void setFace_image(String face_image) {
		this.face_image = face_image;
	}

	@Override
	public String toString() {
		return "VideosVo [id=" + id + ", userId=" + userId + ", audioId=" + audioId + ", videoDesc=" + videoDesc
				+ ", videoPath=" + videoPath + ", videoCategory=" + videoCategory + ", videoSeconds=" + videoSeconds
				+ ", videoWidth=" + videoWidth + ", videoHeight=" + videoHeight + ", coverPath=" + coverPath
				+ ", likeCounts=" + likeCounts + ", status=" + status + ", createTime=" + createTime + ", nickName="
				+ nickName + ", face_image=" + face_image + ", videoFilter=" + videoFilter + "]";
	}

}