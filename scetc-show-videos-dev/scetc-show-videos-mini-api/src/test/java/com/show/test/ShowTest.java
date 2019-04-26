package com.show.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
public class ShowTest {
	
	@Before
	public void init()
	{
		System.out.println("開始執行單元測試");
	}
	@After
	public void after()
	{
		
		System.out.println("執行結束");
	}
	
	

}
