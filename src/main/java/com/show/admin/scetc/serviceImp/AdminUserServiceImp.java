package com.show.admin.scetc.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.show.admin.scetc.mapper.AdminUserMapper;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.service.AdminUserService;
import com.show.admin.scetc.utils.CommonUtils;

/**
 * 接口实现类
 * 
 * @author Ray
 *
 */
@Service
public class AdminUserServiceImp implements AdminUserService {

	@Autowired
	private AdminUserMapper adminUserMapper;

	public List<AdminUser> queryAll() {
		return adminUserMapper.queryAll();
	}

	@Override
	public AdminUser login(String username, String password) {

		AdminUser adminUser = new AdminUser();
		adminUser.setUsername(username);
		adminUser = selectOne(adminUser);
		if (adminUser != null) {
			// 盐加密码
			if (adminUser.getPassword().equalsIgnoreCase(CommonUtils.calculateMD5(adminUser.getSalt() + password))) {
				return adminUser;
			}
		}
		return null;
	}

	// 从数据库中返回一条数据
	public AdminUser selectOne(AdminUser adminUser) {
		return adminUserMapper.selectOne(adminUser);
	}

	@Override
	public AdminUser selectOneById(Long id) {
		AdminUser adminUser =new AdminUser();
		adminUser.setId(id);
		return adminUserMapper.selectOne(adminUser);
	}

	@Override
	public boolean check(String oldPassword) {
		return false;
	}

}
