package com.show.admin.scetc.service;

import java.util.List;

import com.show.admin.scetc.pojo.AdminUser;

public interface AdminUserService {

	public List<AdminUser> queryAll();// 查询全部的管理员用户

	public AdminUser login(String username, String password);//尝试登陆

	public AdminUser selectOne(AdminUser adminUser);//获取一条信息
	
	public AdminUser selectOneById(Long id);//查询一条信息根据id

	public boolean check(String oldPassword);//检查初始密码是否正确,如果正确则返回true

}
