package com.show.admin.scetc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 使用swagger2来进行接口测试 切记 正式环境下需要关闭
 * 
 * @author Ray
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
//http://localhost:1010/swagger-ui.html 测试地址
	// 开启swagger接口
	@Value(value = "true")
	Boolean swaggerEnabled;
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				// 是否开启
				.enable(swaggerEnabled).select()
				// 扫描的路径包
				.apis(RequestHandlerSelectors.basePackage("com.show.admin.scetc.controller"))
				// 指定路径处理PathSelectors.any()代表所有的路径
				.paths(PathSelectors.any()).build().pathMapping("/");
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot-Swagger2集成和使用-徐塬峰").description("springboot | swagger")
				// 作者信息
				.contact(new Contact("snows", "https://blog.csdn.net/RAVEEE", "986771570@qq.com")).version("1.0.0")
				.build();
	}

}
