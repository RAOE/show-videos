package com.show.admin.scetc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.show.admin.scetc.interceptor.DemoInterceptor;

/**
 * 全局配置类webmvcconfigurerAdapter
 * 
 * @author Ray
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	//从配置文件中拿到相关的配置
	@Value("${classpath_mapping}")
	private String classpath_mapping;
	@Value("${url_mapping}")
	private String url_mapping;
	/**
	 * 定义虚拟映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 重写方法
		// 修改tomcat 虚拟映射
		registry.addResourceHandler("/**").addResourceLocations(classpath_mapping).// 启用动态发布
				addResourceLocations(url_mapping);// 定义相对路径 很重要
	}

	// 用于测试用户请求的时间
	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}

//开发环境暂时关闭
//	// 用于登陆的权限验证
//	@Bean
//	public LoginInterceptor loginInterceptor() {
//		return new LoginInterceptor();
//	}
//	
	// 添加拦截器到项目中去开发环境下暂时关闭
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());// 记录请求的时间
		// 需要配置白名单 对部分页面不进行拦截 excludePathPatterns不进行拦截的名单
//        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/adminUser/login","/other/*",
//       		"/adminUser/loginSubmit","/adminUser/logout.do");

	}

}
