package com.show.admin.scetc.service;

import java.util.List;

import com.show.admin.scetc.pojo.Category;

public interface CategoryService {

	List<Category> queryAll();

	void add(Category category);
	

	
	
}
