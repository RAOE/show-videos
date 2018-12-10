package com.show.admin.scetc.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.show.admin.scetc.mapper.ReportMapper;
import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.pojo.UsersReport;
import com.show.admin.scetc.pojo.UsersReportVo;
import com.show.admin.scetc.service.ReportService;

/**
 * 接口实现类
 * 
 * @author Ray
 *
 */
@Service
public class ReportServiceImp implements ReportService {

	@Autowired
	private ReportMapper reportMapper;

	@Override
	public PageResult queryAll(Integer page, Integer pageSize, String keyword) {
		PageHelper.startPage(page, pageSize);
		List<UsersReportVo> list = reportMapper.queryAll();
		PageInfo<UsersReportVo> pageList = new PageInfo<>(list);
		PageResult pageResult = new PageResult();
		pageResult.setPage(page);
		pageResult.setTotal(pageList.getPages());
		pageResult.setRows(list);
		pageResult.setRecords(pageList.getTotal());
		return pageResult;
	}

}
