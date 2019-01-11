package com.show.admin.scetc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.pojo.Roles;
import com.show.admin.scetc.service.RolesService;
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
	private RolesService rolesService;

	// 查询所有的权限数据
	@RequestMapping("queryAll")
	public XyfJsonResult queryAll() {
        
		return XyfJsonResult.ok(rolesService.queryAll());
	}
}
