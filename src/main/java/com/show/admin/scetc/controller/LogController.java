package com.show.admin.scetc.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.utils.CommonUtils;
import com.show.admin.scetc.utils.XyfJsonResult;

/**
 * 
 * @author Ray
 *
 */
@RestController
@RequestMapping("/log")
public class LogController extends BasicController {

	// 返回首页
	@PostMapping("/queryAll")
	public XyfJsonResult queryAll(String page,String pageSize) 
	{  
		List<String> newList=new ArrayList<String>();
		List<String> list=redis.range(Operate_REDIS_SESSION);
		if(!CommonUtils.isEmpty(page)&&!CommonUtils.isEmpty(pageSize)&&list.size()>=Integer.parseInt(pageSize))
		{
		int p=Integer.parseInt(page);
		int s=Integer.parseInt(pageSize);
		newList=list.subList(0,s);
        return new XyfJsonResult(newList);
		}
        return new XyfJsonResult(list);
	}

}
