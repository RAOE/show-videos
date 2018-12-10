package com.show.admin.scetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.service.VideoService;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 视频操作
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/video")
public class VideoController extends BasicController {

	@Autowired
	private VideoService videoService;

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome to my wolrd";
	}

	@PostMapping("/selectVideoType")
	public XyfJsonResult selectVideoType(String keyword,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize) {
		PageResult pageResult = videoService.selectVideoType(page, pageSize, keyword);
		return XyfJsonResult.ok(pageResult);
	}

	@RequestMapping("/queryAll")
	public XyfJsonResult queryAll(String keyword,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize, String status) {
		if (page == null) {
			page = 1;
		}
		PageResult pageResult = videoService.queryAll(page, pageSize, keyword, status);
		return XyfJsonResult.ok(pageResult);
	}

	@RequestMapping("/updateVideo")
	public XyfJsonResult updateVideo(String status, String id) {

		if (status.equals(DELETE)) {
			videoService.delete(id);
		} else if (status.equals(UPDATE)) {
			videoService.update(id);
		}
		return XyfJsonResult.ok();
	}

}
