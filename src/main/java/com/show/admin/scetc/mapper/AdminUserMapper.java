package com.show.admin.scetc.mapper;

import java.util.List;


import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.utils.MyMapper;
public interface AdminUserMapper extends MyMapper<AdminUser> {
	List<AdminUser> queryAll();
}
