package com.show.admin.scetc.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.show.admin.scetc.mapper.AdminToRoleMapper;
import com.show.admin.scetc.mapper.BgmMapper;
import com.show.admin.scetc.mapper.PowerMapper;
import com.show.admin.scetc.mapper.RolesMapper;
import com.show.admin.scetc.mapper.RolesToPowerMapper;
import com.show.admin.scetc.pojo.AdminToRole;
import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.pojo.Power;
import com.show.admin.scetc.pojo.Roles;
import com.show.admin.scetc.pojo.RolesToPower;
import com.show.admin.scetc.service.BgmService;
import com.show.admin.scetc.service.RolesService;

/**
 * 接口实现类
 * 
 * @author Ray
 *
 */
@Service
public class RolesServiceImp implements RolesService {

	@Autowired
	private RolesMapper rolesMapper;
	@Autowired
	private PowerMapper powerMapper;
	@Autowired
	private RolesToPowerMapper RolesToPowerMapper;
	@Autowired
	private AdminToRoleMapper adminToRolesMapper;

	@Override
	public List<Roles> queryAllRoles() {
		return rolesMapper.selectAll();
	}

	@Override
	public List<Power> queryAllPowers() {
		return powerMapper.selectAll();
	}

	@Override
	public List<RolesToPower> queryAllRolesToPower() {
		return RolesToPowerMapper.selectAll();
	}

	@Override
	public List<AdminToRole> queryAllAdminToRole() {
		return adminToRolesMapper.selectAll();
	}

	@Override
	public Boolean addAdminUserAndRoles(String adminId,String roleId) {
		
		//具体的逻辑 添加之前先查询是否存在如果存在了则更新
		
		
		AdminToRole atr=new AdminToRole();
		atr.setAdminId(adminId);
		atr.setRoleId(roleId);
		adminToRolesMapper.insert(atr);
		return true;
	}

}
