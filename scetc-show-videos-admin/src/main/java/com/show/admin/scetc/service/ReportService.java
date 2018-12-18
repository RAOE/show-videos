package com.show.admin.scetc.service;

import com.show.admin.scetc.pojo.PageResult;

public interface ReportService {

	/**
	 * 查询全部举报模块
	 * 
	 * @return
	 */
	PageResult queryAll(Integer page, Integer pageSize, String keyword);

	void undercarriageById(String id, String status);

}
