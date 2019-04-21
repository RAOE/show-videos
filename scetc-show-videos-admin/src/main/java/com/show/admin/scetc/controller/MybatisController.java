package com.show.admin.scetc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.show.admin.scetc.annotation.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.service.AdminUserService;

/**
 * 该类用来作为mybatis增删该查测试
 * 
 * @author Ray
 */
@RestController
@RequestMapping("mybatis")
public class MybatisController {

	@Autowired
	private AdminUserService adminUserService;

	// 插入一条数据到mysql中
	@PostMapping("/add")
	@SysLog
	public String add(HttpServletRequest request, Long id, String username, String realName, String password,
			String phoneNumber, String email, String position, String salt, String qq) {
		return "hello springboot~!";
	}

	// 从数据库中查询一个List集合
	@RequestMapping("/queryAll")
	@SysLog
	public List<AdminUser> queryAll() {
		return adminUserService.queryAll();
	}

}
