package com.show.admin.scetc.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "videos")
public class Video {

	@Id
	private String id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "audio_id")
	private String audioId;

	@Column(name = "video_desc")
	private String videoDesc;

	// 视频分类
	@Column(name = "video_category")
	private String videoCategory;

	@Column(name = "video_path")
	private String videoPath;

	@Column(name = "video_seconds")
	private Float videoSeconds;

	@Column(name = "video_width")
	private Integer videoWidth;

	@Column(name = "video_height")
	private Integer videoHeight;

	@Column(name = "cover_path")
	private String coverPath;

	@Column(name = "like_counts")
	private Long likeCounts;

	private Integer status;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "video_filter")
	private String videoFileter;// 视频的滤镜

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
	 * @return user_id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return audio_id
	 */
	public String getAudioId() {
		return audioId;
	}

	/**
	 * @param audioId
	 */
	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}

	/**
	 * @return video_desc
	 */
	public String getVideoDesc() {
		return videoDesc;
	}

	/**
	 * @param videoDesc
	 */
	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}

	/**
	 * @return video_path
	 */
	public String getVideoPath() {
		return videoPath;
	}

	/**
	 * @param videoPath
	 */
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	/**
	 * @return video_seconds
	 */
	public Float getVideoSeconds() {
		return videoSeconds;
	}

	/**
	 * @param videoSeconds
	 */
	public void setVideoSeconds(Float videoSeconds) {
		this.videoSeconds = videoSeconds;
	}

	/**
	 * @return video_width
	 */
	public Integer getVideoWidth() {
		return videoWidth;
	}

	/**
	 * @param videoWidth
	 */
	public void setVideoWidth(Integer videoWidth) {
		this.videoWidth = videoWidth;
	}

	/**
	 * @return video_height
	 */
	public Integer getVideoHeight() {
		return videoHeight;
	}

	/**
	 * @param videoHeight
	 */
	public void setVideoHeight(Integer videoHeight) {
		this.videoHeight = videoHeight;
	}

	/**
	 * @return cover_path
	 */
	public String getCoverPath() {
		return coverPath;
	}

	/**
	 * @param coverPath
	 */
	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	/**
	 * @return like_counts
	 */
	public Long getLikeCounts() {
		return likeCounts;
	}

	/**
	 * @param likeCounts
	 */
	public void setLikeCounts(Long likeCounts) {
		this.likeCounts = likeCounts;
	}

	/**
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return create_time
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @param videoCategory
	 */
	public String getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}

	public String getVideoFileter() {
		return videoFileter;
	}

	public void setVideoFileter(String videoFileter) {
		this.videoFileter = videoFileter;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", userId=" + userId + ", audioId=" + audioId + ", videoDesc=" + videoDesc
				+ ", videoCategory=" + videoCategory + ", videoPath=" + videoPath + ", videoSeconds=" + videoSeconds
				+ ", videoWidth=" + videoWidth + ", videoHeight=" + videoHeight + ", coverPath=" + coverPath
				+ ", likeCounts=" + likeCounts + ", status=" + status + ", createTime=" + createTime + ", videoFileter="
				+ videoFileter + "]";
	}

}
