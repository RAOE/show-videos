package com.show.admin.scetc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.show.admin.scetc.pojo.UsersReport;
import com.show.admin.scetc.pojo.UsersReportVo;
import com.show.admin.scetc.utils.MyMapper;

public interface ReportMapper extends MyMapper<UsersReport> {
	/**
	 * 查询全部的举报信息
	 * 
	 * @return
	 */
	List<UsersReportVo> searchAll(@Param("keyword") String keyword);

}
