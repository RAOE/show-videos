package com.show.admin.scetc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.utils.ImageCodeUtils;

/**
 * @author Ray
 */
@RestController
@RequestMapping("other")
public class OtherController {

	@RequestMapping("/imageCode.do")
	public void sendImageCode(HttpServletResponse response, HttpServletRequest request) {
		ImageCodeUtils.sendImageCode(request.getSession(), response);
	}


}
