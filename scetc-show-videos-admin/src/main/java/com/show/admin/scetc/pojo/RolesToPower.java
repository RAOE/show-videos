package com.show.admin.scetc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 不同权限对应的能力
 * <p>
 * Title: RolesToPower.java<／p>
 * <p>
 * Description: <／p>
 * 
 * @author Ray
 ** @date 2019年1月6日
 * @version 1.0
 */
@Table(name = "role_to_power")
public class RolesToPower {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "roleId")
	private Long roleId;
	@Column(name = "powerId")
	private Long powerId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPowerId() {
		return powerId;
	}
	public void setPowerId(Long powerId) {
		this.powerId = powerId;
	}
	
	
	
	

}
