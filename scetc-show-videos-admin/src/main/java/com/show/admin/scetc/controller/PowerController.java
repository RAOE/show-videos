package com.show.admin.scetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.service.PowerService;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 权限power
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/power")
public class PowerController {

	@Autowired
	private PowerService powerService;

	@RequestMapping("/queryAll")
	public XyfJsonResult queryAll() {
		return XyfJsonResult.ok(powerService.queryAll());

	}

}
