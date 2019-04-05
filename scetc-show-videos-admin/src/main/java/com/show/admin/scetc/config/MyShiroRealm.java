package com.show.admin.scetc.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.service.AdminUserService;

public class MyShiroRealm extends AuthorizingRealm{
	
	Boolean cachingEnabled=true;
	@Autowired
	public AdminUserService AdminUserService;
 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
 
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        //在这里给用户授权		
		simpleAuthorInfo.addRole("admin");
		return simpleAuthorInfo;
	}
 
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		//获取基于用户名和密码的令牌  
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String account = token.getUsername();
	//	User user = userService.selectByAccount(account);//根据登陆名account从库中查询user对象
		AdminUser adminUser=new AdminUser();
		adminUser.setUsername(account);
		adminUser=AdminUserService.selectOne(adminUser);
		System.out.println("用户"+adminUser);
		if(adminUser==null){throw new AuthenticationException("用户不存在");}
		
		//进行认证，将正确数据给shiro处理
		//密码不用自己比对，AuthenticationInfo认证信息对象，一个接口，new他的实现类对象SimpleAuthenticationInfo
		/*	第一个参数随便放，可以放user对象，程序可在任意位置获取 放入的对象
		 * 第二个参数必须放密码，
		 * 第三个参数放 当前realm的名字，因为可能有多个realm*/
		  AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminUser.getUsername(), adminUser.getPassword(),
                  this.getName());
          return authenticationInfo;
		//如果有问题，向上抛异常，一直抛到控制器
	}
	
}