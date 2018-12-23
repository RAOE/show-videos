package com.show.admin.scetcshowvideosadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.mysql.fabric.xmlrpc.base.Member;
import com.show.admin.scetc.ScetcShowVideosAdminApplication;

/**
 * 编写测试代码
 * 
 * @author Ray
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScetcShowVideosAdminApplication.class)
@WebAppConfiguration
public class ScetcShowVideosAdminApplicationTests {

    private TestRestTemplate template = new TestRestTemplate();
	/**
	 * 
	 */
	@Before
	public void init() {
		System.out.println("-----初始化代码---------");

	}

	@Test
	public void test1() {
		Map<String, Object> map = new HashMap();
		String url = "http://localhost:8082/welcome";
		String a= template.patchForObject(url, null, String.class);
		System.out.println(a.toString());
	}

	


	/**
	 * 测试代码执行完毕
	 */
	@After
	public void after() {
		System.out.println("-----执行测试完毕-----------");

	}

}
