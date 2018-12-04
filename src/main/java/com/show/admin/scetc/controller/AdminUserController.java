package com.show.admin.scetc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.show.admin.scetc.pojo.AdminUser;
import com.show.admin.scetc.service.AdminUserService;
import com.show.admin.scetc.utils.ImageCodeUtils;

@RestController
@RequestMapping("/adminUser")
public class AdminUserController extends BasicController {

	// 返回首页
	@Autowired
	private AdminUserService adminUserService;

	// 注销操作
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {

		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
		if (adminUser != null) // 如果存在 就从redis缓存数据库中删掉它
		{
			redis.del(User_REDIS_SESSION + adminUser.getId());
		}
		request.getSession().invalidate();// 销毁session 中的数据
		return new ModelAndView("thymeleaf/login");
	}

	// 注销操作
	@RequestMapping("/forgetPassword.do")
	public String forgetPassword(HttpServletRequest request, HttpServletResponse response) {

		return "thymeleaf/forgetPassword";
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("thymeleaf/login");
	}

	/**
	 * 校验用户名密码验证码
	 * 
	 * @param username
	 * @param password
	 * @param verifyCode
	 * @return
	 */
	@PostMapping("loginSubmit")
	public ModelAndView loginSubmit(HttpServletRequest request, String username, String password, String verifyCode,
			Model model) {
		if (!ImageCodeUtils.checkImageCode(request.getSession(), verifyCode)) {
			model.addAttribute("message", "验证码输入错误");
			return new ModelAndView("thymeleaf/login");
		}
		// 尝试登陆操作
		AdminUser adminUser = adminUserService.login(username, password);
		if (adminUser == null) {
			// 登陆失败
			model.addAttribute("message", "账号密码错误");
			return new ModelAndView("thymeleaf/login");
		}
		// 检查账号是否被禁用了
		// 登陆成功,登陆成功之后更新用户的登陆时间
		ModelAndView modelAndView = new ModelAndView("thymeleaf/index");
		modelAndView.addObject("adminUser", adminUser);
		redis.set(User_REDIS_SESSION + adminUser.getId(), adminUser.toString());// 保存账号信息到redis 缓存中
		SimpleDateFormat formate = new SimpleDateFormat();
		String date = formate.format(new Date());
		redis.lpush(Operate_REDIS_SESSION, date + "&nbsp;&nbsp;&nbsp;" + adminUser.getRealName() + ":登陆了系统");// 存放到redis
		request.getSession().setAttribute("adminUser", adminUser);// 将账号密码添加到session 中
		return modelAndView;
	}

}
