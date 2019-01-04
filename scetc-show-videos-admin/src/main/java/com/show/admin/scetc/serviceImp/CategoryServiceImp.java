package com.show.admin.scetc.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.show.admin.scetc.mapper.CategoryMapper;
import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.pojo.PageResult;
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
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Category> queryAll() {
		List<Category> list = categoryMapper.selectAll();
		return list;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(Category category) {
		categoryMapper.insert(category);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		Category category = new Category();
		category.setId(id);
		categoryMapper.delete(category);

	}

	@Override
	public PageResult queryAll(String title, String keyword, Integer page, Integer pageSize) {

		PageHelper.startPage(page, pageSize);
		List<Category> list = categoryMapper.queryAll(keyword, title);
//		// 3、获取分页查询后的数据
		PageInfo<Category> pageInfo = new PageInfo<>(list);
//		// 4、封装需要返回的分页实体
		PageResult result = new PageResult();
//		// 设置获取到的总记录数total：
		result.setTotal(pageInfo.getPages());
//		// 设置数据集合rows：
		result.setRows(list);
		result.setRecords(pageInfo.getTotal());
		result.setPage(page);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void update(Long id, String name, String content, MultipartFile file) {

		Category category = new Category();
		category.setId(id);
		System.out.println(id);

	}

	@Override
	public Category selectOne(Long id) {

		Category category = new Category();
		category.setId(id);
		return categoryMapper.selectOne(category);
	}

}
