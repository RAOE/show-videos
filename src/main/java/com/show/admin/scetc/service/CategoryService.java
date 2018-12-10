package com.show.admin.scetc.service;

import java.util.List;

import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.pojo.PageResult;

/**
 * 专栏管理
 * 
 * @author Ray
 */
public interface CategoryService {
	// 根据title 或者根据keyword 查询出相关的额专栏信息
	PageResult queryAll(String keyword, Integer page, Integer pageSize);

	// 添加一个专栏的信息
	void add(Category category);

	// 根据id 删除一个专栏的信息
	void delete(Long id);

	// 查询全部的专栏信息
	List<Category> queryAll();

}
