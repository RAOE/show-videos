package com.show.admin.scetc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.pojo.PageResult;

/**
 * 专栏管理
 * 
 * @author Ray
 */
public interface CategoryService {
	// 根据title 或者根据keyword 查询出相关的额专栏信息
	PageResult queryAll(String title, String keyword, Integer page, Integer pageSize);

	// 添加一个专栏的信息
	void add(Category category);

	// 根据id 删除一个专栏的信息
	void delete(Long id);

	// 查询全部的专栏信息
	List<Category> queryAll();

	// 根据id 来更新一个专栏的基本信息
	void update(Long id, String title, String description, MultipartFile file,String savePath);

	// 根据id查询出一条专栏的详细信息
	Category selectOne(Long id);

}
