package com.show.admin.scetc.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public XyfJsonResult queryAll() {
         List list=redis.range(Operate_REDIS_SESSION);
		 return new XyfJsonResult(list);
	}

}
