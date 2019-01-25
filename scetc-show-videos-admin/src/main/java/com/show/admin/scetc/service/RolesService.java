package com.show.admin.scetc.service;

import java.util.List;

import com.show.admin.scetc.pojo.AdminToRole;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.pojo.Power;
import com.show.admin.scetc.pojo.Roles;
/**
 * 权限相关的服务
* <p>Title: RolesService.java<／p>
* <p>Description: <／p>
 * @author Ray
 **@date 2019年1月13日
 * @version 1.0
 */
import com.show.admin.scetc.pojo.RolesToPower;
public interface RolesService {

	/**
	 * 查询所有权限信息
	 * @return
	 */
	public List<Roles> queryAllRoles();//查询所有角色
	public List<Power> queryAllPowers();//查询所角色拥有的能力/
	public List<RolesToPower> queryAllRolesToPower();//查询所有的角色能力关系表
	public List<AdminToRole> queryAllAdminToRole();//查询所有的管理员与角色的关系表
	public Boolean addAdminUserAndRoles(String adminId,String roleId);//添加一个角色与用户关系
	public List<AdminUser> queryAllAdminUserByRoleId(String roleId);//查询当前权限下面所拥有的所有管理员账户
	public boolean isExsits(String adminId, String roleId);//判断数据库中是否存在这条消息 ，如果存在就不能添加了
	
}
