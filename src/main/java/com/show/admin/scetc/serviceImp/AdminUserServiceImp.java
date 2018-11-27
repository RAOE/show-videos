package com.show.admin.scetc.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.show.admin.scetc.mapper.AdminUserMapper;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.service.AdminUserService;

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

	public AdminUser findByUserName(String username) {
		System.out.println("找到了");
		return null;
	}
	public List<AdminUser> queryAll() {
		return adminUserMapper.queryAll();
	}
	
	
	

}
