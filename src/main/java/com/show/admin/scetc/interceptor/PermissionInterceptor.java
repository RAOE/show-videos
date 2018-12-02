package com.show.admin.scetc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.utils.CommonUtils;
import com.show.admin.scetc.utils.JsonUtils;
import com.show.admin.scetc.utils.XyfJsonResult;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
		// 如果用户还没有登录，让用户去登录
		if (adminUser == null) {
			// 返回json格式的权限不足信息
			if (CommonUtils.isEmpty(request.getHeader("x-requested-with"))) {
				response.getWriter().print("需要重新登录");
			} else {
				response.getWriter().print(JsonUtils.toJson(XyfJsonResult.errorMsg("需要重新登录")));
			}
			return false;
		}
		return true;
	}
}
