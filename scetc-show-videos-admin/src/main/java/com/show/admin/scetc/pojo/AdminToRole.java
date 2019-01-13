package com.show.admin.scetc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 定义管理员账户
 * 
 * 管理员与角色关系表
 * @author Ray
 */
@Table(name = "admin_to_role")
public class AdminToRole {

	@Id
	@Column(name="id")
	private Long id;
	@Column(name="adminId")
	private String adminId;
	@Column(name="roleId")
	private String roleId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "AdminToRole [id=" + id + ", adminId=" + adminId + ", roleId=" + roleId + "]";
	}

	
	
	
}
