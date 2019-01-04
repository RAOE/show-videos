package com.show.admin.scetc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.show.admin.scetc.pojo.Category;
import com.show.admin.scetc.utils.MyMapper;

public interface CategoryMapper extends MyMapper<Category> {

	/**
	 * 分页查询全部的专栏
	 * 
	 * @param keyword
	 * @return
	 */
	List<Category> queryAll(@Param("keyword") String keyword, @Param("title") String title);

}
