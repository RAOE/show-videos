package com.show.admin.scetc.mapper;

import java.util.List;

import com.show.admin.scetc.pojo.AdminToRole;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.pojo.Power;
import com.show.admin.scetc.utils.MyMapper;

public interface AdminToRoleMapper extends MyMapper<AdminToRole> {

	List<AdminUser> queryAllAdminUserByRoleId(String roleId);



}
