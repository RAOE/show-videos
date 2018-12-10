package com.show.admin.scetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.pojo.PageResult;
import com.show.admin.scetc.service.ReportService;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 *     举报模块
 * @author Ray
 */
@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@PostMapping("/queryAll")
	public XyfJsonResult queryAll(String keyword, Integer page,Integer pageSize)
	{
		PageResult list=reportService.queryAll(page, pageSize, keyword);
        return XyfJsonResult.ok(list);
	}
	
	
	
	
}
