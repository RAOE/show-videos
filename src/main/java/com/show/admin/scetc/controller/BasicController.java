package com.show.admin.scetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.show.admin.scetc.utils.RedisOperator;

/**
 * 
 * @author 2016wlw2 徐塬峰
 */
@RestController
public class BasicController {
	
	 @Value("${web.upload.path}")
     public  String filePath;
     
	 @Value("${bgm.upload.path}")
     public  String bgm_filePath;
	 
	 @Autowired
	 public RedisOperator redis;
	 
	 //默认的用户的键
	 public static final String  User_REDIS_SESSION="user-redis-session";
	 public static final String  Operate_REDIS_SESSION="operate_redis_session";

	 public final String DELETE="2";//根据前端的status来判定执行什么操作
	 public final String UPDATE="1";//更新操作


	
	
	
	
}
