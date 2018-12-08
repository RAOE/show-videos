package com.show.admin.scetc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.show.admin.scetc.interceptor.DemoInterceptor;

import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
//扫描mapper相关的包
@MapperScan(basePackages="com.show.admin.scetc.mapper")
public class ScetcShowVideosAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScetcShowVideosAdminApplication.class, args);
	}
	
}
