package com.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.pojo.Category;
import com.show.service.CategoryService;
import com.show.utils.XyfJsonResult;

@RestController
@RequestMapping("/category")
/**
 * 
 * @author 2016wlw2 徐塬峰 创建时间：2018年6月11日 下午4:14:49
 */
public class CategoryController extends BasicController {
	
	@Autowired
	private CategoryService categoryService;
	@RequestMapping("queryAll")
	public XyfJsonResult queryAll()
	{
		List<Category> list=categoryService.queryCategroyList();
		new XyfJsonResult();
		return XyfJsonResult.ok(list);
	}
	
	
	
}
