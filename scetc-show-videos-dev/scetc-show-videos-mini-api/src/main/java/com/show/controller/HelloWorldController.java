package com.show.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String Hello() {
		return "Hello Spring Boot~";
	}
	@RequestMapping("/")
	public String index() {
		return "Welcome to use show-api";
	}
	
}
