package com.show.admin.scetc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.show.admin.scetc.mapper")
public class ScetcShowVideosAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScetcShowVideosAdminApplication.class, args);
	}
}
