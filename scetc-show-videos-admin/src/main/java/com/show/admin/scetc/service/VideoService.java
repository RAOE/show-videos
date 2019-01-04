package com.show.admin.scetc.service;

import java.util.List;

import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.pojo.Video;

public interface VideoService {

	/**
	 * 查询短视频
	 * 
	 * @return
	 */
	List<Video> queryAll();

	/**
	 * 分页查询全部的短视频
	 * 
	 * @param page
	 * @param pageSize
	 * @param keyword
	 * @param status
	 * @return
	 */
	PageResult queryAll(Integer page, Integer pageSize, String keyword, String title);

	/**
	 * 查询视频的类型
	 * 
	 * @param page
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	PageResult selectVideoType(Integer page, Integer pageSize, String keyword);

	/**
	 * 更新
	 * 
	 * @param id
	 */
	void update(String id);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * 查询系统中视频的总量
	 */
	int selectCountAll();

}
