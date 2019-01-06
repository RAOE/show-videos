package com.show.admin.scetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.utils.RedisOperator;

/**
 * @author 2016wlw2 徐塬峰
 */
@RestController
public class BasicController {

	//文件上传路径
	@Value("${web.upload.path}")
	public String filePath;

	//背景音乐的上传路径
	@Value("${bgm.upload.path}")
	public String bgm_filePath;

	@Autowired
	public RedisOperator redis;// 注入redis客户端

	// 默认的用户的键以及操作日志的键名称
	public static final String User_REDIS_SESSION = "user-redis-session";
	public static final String Operate_REDIS_SESSION = "operate_redis_session";
	//根据前端传入的status操作来决定执行什么操作
	public final String DELETE = "2";//
	public final String UPDATE = "1";//

}
