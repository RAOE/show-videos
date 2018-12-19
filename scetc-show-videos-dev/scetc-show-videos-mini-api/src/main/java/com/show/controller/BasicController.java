package com.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.show.utils.RedisOperator;
/**
 * 
 * @author 2016wlw2 徐塬峰
 * 创建时间：2018年6月11日 下午4:03:26
 */
@RestController
public class BasicController {
    @Autowired
	public RedisOperator redis;
    public static final String  Filter_DEFINE="define";//默认
    public static final String  User_REDIS_SESSION="user-redis-session";
 
    @Value("${web.upload.path}")
    public  String  FILe_SPACE;
	@Value("${ffmepg.path}")
	public String FFMPEGEXE;
	@Value("${page_size}")
	public int PAGE_SIZE;
}
