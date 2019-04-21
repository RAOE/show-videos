package com.show.admin.scetc.controller;

import com.show.admin.scetc.annotation.SysLog;
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

	/**
	 * 查詢視頻的分類
	 * 
	 * @param keyword
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@PostMapping("/selectVideoType")
	@SysLog
	public XyfJsonResult selectVideoType(String keyword,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize) {
		PageResult pageResult = videoService.selectVideoType(page, pageSize, keyword);
		return XyfJsonResult.ok(pageResult);
	}

	/**
	 * 分頁查詢視頻
	 * 
	 * @param keyword
	 * @param page
	 * @param pageSize
	 * @param status
	 * @return
	 */
	@RequestMapping("/queryAll")
	@SysLog
	public XyfJsonResult queryAll(String keyword, String title,
			@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize, String status) {
		if (page == null) {
			page = 1;
		}
		PageResult pageResult = videoService.queryAll(page, pageSize, keyword, title);
		return XyfJsonResult.ok(pageResult);
	}

	/**
	 * 根據狀態來更新狀態
	 * 
	 * @param status
	 * @param id
	 * @return
	 */
	@RequestMapping("/updateVideo")
	@SysLog
	public XyfJsonResult updateVideo(String status, String id) {

		if (status.equals(DELETE)) {
			videoService.delete(id);
		} else if (status.equals(UPDATE)) {
			videoService.update(id);
		}
		return XyfJsonResult.ok();
	}

	/**
	 * 编辑视频
	 * 
	 * @return
	 */
	@RequestMapping("/editVideos")
	@SysLog
	public XyfJsonResult editVideosSubmit() {
		return XyfJsonResult.ok();// 编辑视频
	}

}
