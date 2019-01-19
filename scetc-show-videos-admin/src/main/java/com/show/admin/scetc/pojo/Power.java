package com.show.admin.scetc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 声明权限的能力
* <p>Title: Power.java<／p>
* <p>Description: <／p>
 * @author Ray
 **@date 2019年1月6日
 * @version 1.0
 */
@Table(name="power")
public class Power {

	@Id
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="path")
	private String path;
	
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
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
	
	
	
	
	
}
