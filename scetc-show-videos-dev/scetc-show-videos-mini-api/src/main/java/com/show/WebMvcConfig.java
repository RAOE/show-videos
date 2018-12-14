package com.show;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Value("${classpath_mapping}")
	private String classpath_mapping;
	
	@Value("${url_mapping}")
	private String url_mapping;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//重写方法
		//修改tomcat 虚拟映射
		registry.addResourceHandler("/**").
		addResourceLocations(classpath_mapping).//启用动态发布
		addResourceLocations(url_mapping);//定义相对路径 很重要
		//发布到
	}

	
	
	
}
