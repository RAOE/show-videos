package com.show.admin.scetc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.pojo.Roles;
import com.show.admin.scetc.service.RolesService;
import com.show.admin.scetc.utils.CommonUtils;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 对权限栏目的增删改查
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/role")
public class RolesController {
	@Autowired
	private RolesService rolesService;// 权限服务类
	// 查询所有的权限数据

	@RequestMapping("queryAllRole")
	public XyfJsonResult queryAllRole() {
		return XyfJsonResult.ok(rolesService.queryAllRoles());
	}

	// 查询所有的能力
	@RequestMapping("queryAllPower")
	public XyfJsonResult queryAllPower() {
		return XyfJsonResult.ok(rolesService.queryAllPowers());
	}

	// 查詢所有的能力于角色的關係
	@RequestMapping("queryAllRoleToPower")
	public XyfJsonResult queryAll() {
		return XyfJsonResult.ok(rolesService.queryAllRolesToPower());
	}

	// 查询所有管理员与角色的对应关系
	@RequestMapping("queryAllAdminToRole")
	public XyfJsonResult queryAllAdminToRole() {
		return XyfJsonResult.ok(rolesService.queryAllAdminToRole());
	}

	// 将用户添加到指定的角色中
	@RequestMapping("addAdminUserAndRole")
	public XyfJsonResult addAdminUserAndRole(String adminId, String roleId) {
		if(CommonUtils.isEmpty(adminId)||CommonUtils.isEmpty(roleId))
		{
			return XyfJsonResult.errorMsg("用户id或者角色id不能为空");
		}
		rolesService.addAdminUserAndRoles(adminId, roleId);
		return XyfJsonResult.ok();
	}

}
