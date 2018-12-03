package com.show.admin.scetc.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.show.admin.scetc.mapper.CategoryMapper;
import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.service.CategoryService;

/**
 * 接口实现类
 * 
 * @author Ray
 *
 */
@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
    @Transactional(propagation=Propagation.SUPPORTS)
	public List<Category> queryAll() {
		List<Category> list=categoryMapper.selectAll();
		return list;
	}

	
	
	

}
