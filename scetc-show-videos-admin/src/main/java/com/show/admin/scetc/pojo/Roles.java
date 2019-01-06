package com.show.admin.scetc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限表
 * <p>
 * Title: Roles.java<／p>
 * <p>
 * Description: <／p>
 * 
 * @author Ray
 ** @date 2019年1月6日
 * @version 1.0
 */
@Table(name="roles")
public class Roles {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;

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
