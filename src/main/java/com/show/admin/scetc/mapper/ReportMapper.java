package com.show.admin.scetc.mapper;

import java.util.List;

import com.show.admin.scetc.pojo.UsersReport;
import com.show.admin.scetc.pojo.UsersReportVo;
import com.show.admin.scetc.utils.MyMapper;

public interface ReportMapper extends MyMapper<UsersReport> {

	List<UsersReportVo> queryAll();

}
