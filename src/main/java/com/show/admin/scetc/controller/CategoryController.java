package com.show.admin.scetc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.service.CategoryService;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BasicController {

	@Autowired 
	private  CategoryService categoryService;
	// 返回首页
	@PostMapping("/queryAll")
	public XyfJsonResult queryAll() {
	List<Category> list=categoryService.queryAll();
	return new XyfJsonResult(list);
	}

}
