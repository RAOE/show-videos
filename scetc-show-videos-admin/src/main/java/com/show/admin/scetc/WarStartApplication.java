package com.show.admin.scetc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WarStartApplication extends SpringBootServletInitializer{

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(ScetcShowVideosAdminApplication.class);
	}
	
	   public static void main(String[] args) {
	        SpringApplication.run(ScetcShowVideosAdminApplication.class, args);
	    }
	
}
