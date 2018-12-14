package com.show.admin.scetc.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 专栏管理
 * 
 * @author Ray
 */
@Table(name = "category")
public class Category {
	@Id
	@Column(name = "Id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "content")
	private String content;
	@Column(name = "createTime")
	private Date createTime;
	@Column(name = "isDeleted")
	private Boolean isDeleted;
	@Column(name = "imageUrl")
	private String imageUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", content=" + content + ", createTime=" + createTime
				+ ", isDeleted=" + isDeleted + ", imageUrl=" + imageUrl;
	}

}
