package com.show.admin.scetc.service;

import java.util.List;

import com.show.admin.scetc.pojo.AdminUser;

public interface AdminUserService {

	public List<AdminUser> queryAll();// 查询全部的管理员用户

	public AdminUser login(String username, String password);

}
