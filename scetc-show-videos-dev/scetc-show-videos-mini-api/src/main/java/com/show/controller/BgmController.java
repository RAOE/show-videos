package com.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.service.BgmService;
import com.show.utils.XyfJsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bgm")
@Api(value = "背景音乐", tags = { "背景音乐业务controller" })

public class BgmController {
	@Autowired
	private BgmService bgmService;
	@ApiOperation(value = "列表", notes = "获取背景音乐列表")
	@PostMapping("/list")
	public XyfJsonResult list() {
		
		return XyfJsonResult.ok(bgmService.queryBgmList());
	}
	@ApiOperation(value = "列表", notes = "获取视频分类列表")
	@PostMapping("/listVideoCategory")
	public XyfJsonResult listVideoCategory() {
		
		return XyfJsonResult.ok(bgmService.queryBgmList());
	}
	
}
