package com.show.admin.scetc.service;

import java.util.List;

import com.show.admin.scetc.pojo.Bgm;
import com.show.admin.scetc.pojo.PageResult;

public interface BgmService {

	/**
	 * 查询全部背景音乐
	 * 
	 * @param title
	 * @param keyword
	 * @param pageSize
	 * @param page
	 * 
	 * @return
	 */
	List<Bgm> queryAll();

	/**
	 * 分页查询 查询关键字
	 * 
	 * @param page
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	PageResult queryAll(Integer page, Integer pageSize, String keyword, String title);

	/**
	 * 更新背景音乐
	 * 
	 * @param id
	 * @param status
	 */
	void updateBgm(Long id, String author, String name);

	/**
	 * 删除背景音乐
	 * 
	 * @param id
	 * @param status
	 */
	void deleteBgm(Long id);

	/**
	 * 插入一条bgm 到数据库
	 * 
	 * @param bgm
	 */
	void insert(Bgm bgm);

	/**
	 * 返回一条bgm信息
	 * 
	 * @param id
	 * @return
	 */
	Bgm selectOne(Long id);

}
