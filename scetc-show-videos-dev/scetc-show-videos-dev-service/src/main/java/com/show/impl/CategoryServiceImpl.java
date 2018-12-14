package com.show.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.show.mapper.BgmMapper;
import com.show.mapper.CategoryMapper;
import com.show.pojo.Bgm;
import com.show.pojo.Category;
import com.show.service.BgmService;
import com.show.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper cateGoryMapper;
	
	@Override
	public List<Category> queryCategroyList() {
		return	cateGoryMapper.selectAll();
	}


}
