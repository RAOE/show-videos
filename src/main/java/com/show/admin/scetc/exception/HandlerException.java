package com.show.admin.scetc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.show.admin.scetc.utils.XyfJsonResult;

@ControllerAdvice
public class HandlerException {

	public static final String ERROR_VIEW = "thymeleaf/500";

	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest request, HttpServletResponse resp, Exception e) throws Exception {
		e.printStackTrace();
		if (isAjax(request)) {
			new XyfJsonResult();
			return XyfJsonResult.errorException(e.getMessage());
		}

		else {

			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", request.getRequestURL());
			mav.setViewName(ERROR_VIEW);
			return e;
		}
	}

	public static boolean isAjax(HttpServletRequest request) {

		return (request.getHeaders("X-Requested-With") != null
				&& "XMLHttpReqeust".equals(request.getHeaders("X-Requested-With").toString()));
	}
}
