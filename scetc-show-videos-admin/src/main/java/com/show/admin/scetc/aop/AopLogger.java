package com.show.admin.scetc.aop;

import java.util.Arrays;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.show.admin.scetc.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.show.admin.scetc.pojo.AdminUser;
import org.springframework.web.multipart.MultipartFile;

/**
 * 使用AOP 面向切面编程来 进行日志记录
 * 
 * @author Ray
 *
 */
@Aspect
@Component
public class AopLogger {

	private Logger logger = Logger.getLogger(getClass());
	@Before("@annotation(com.show.admin.scetc.annotation.SysLog)")
	public Object log(JoinPoint joinPoint) throws Throwable {
		Object[] ob = joinPoint.getArgs();
		// 直接拿到全局的request对象
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		AdminUser adminUser = (AdminUser) request.getSession().getAttribute("adminUser");
		String username = null;
		if (adminUser != null) {
			username = adminUser.getRealName();
		}
		logger.debug("记录下请求内容");
		logger.info(" 记录下请求内容");
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		return ob;
	}
}
