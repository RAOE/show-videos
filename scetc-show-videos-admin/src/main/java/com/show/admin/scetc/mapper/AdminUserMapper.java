package com.show.admin.scetc.mapper;

import java.util.List;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.utils.MyMapper;

public interface AdminUserMapper extends MyMapper<AdminUser> {
	/**
	 * 查询全部的管理员用户
	 * 
	 * @return
	 */
	List<AdminUser> queryAll();
}
