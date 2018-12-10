package com.show.admin.scetc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 定义背景音乐
 * 
 * @author Ray
 *
 */
@Table(name = "bgm")
public class Bgm {
	@Id
	@Column(name = "Id")
	private Long id;
	@Column(name = "author")
	private String author;
	@Column(name = "name")
	private String name;
	@Column(name = "path")
	private String path;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Bgm [id=" + id + ", author=" + author + ", name=" + name + ", path=" + path + "]";
	}

}
