package com.show.admin.scetc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.utils.XyfJsonResult;

@Controller
@RequestMapping("")
public class IndexController extends BasicController {

	/**
	 * 返回主頁
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		// 从request中获取用户的基本信息
		ModelAndView modelAndView = new ModelAndView("thymeleaf/index");
		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
		// 将数据渲染到页面上
		modelAndView.addObject("adminUser", adminUser);
		return modelAndView;
	}

	/**
	 * 主页初始化代码
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public XyfJsonResult init() {

		List<String> list = redis.range(Operate_REDIS_SESSION);// 操作记录只显示前10条 更多需要在操作日志里查看
		if (list.size() >= 10 && list != null) {
			List<String> newList = new ArrayList<String>();
			newList = list.subList(0, 10);
			new XyfJsonResult();
			return XyfJsonResult.ok(newList);
		}
		new XyfJsonResult();
		return XyfJsonResult.ok(list);
	}

	// 500 错误页面
	@RequestMapping("/500")
	public String errorPage() {
		return "thymeleaf/500";
	}

	// 404 页面
	@RequestMapping("/404")
	public String notFoundPage() {
		return "thymeleaf/404";
	}

}
