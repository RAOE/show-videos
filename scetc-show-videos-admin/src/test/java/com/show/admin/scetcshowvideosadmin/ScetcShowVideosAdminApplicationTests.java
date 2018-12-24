package com.show.admin.scetcshowvideosadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.show.admin.scetc.ScetcShowVideosAdminApplication;

/**
 * 编写测试代码
 * 
 * @author Ray
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScetcShowVideosAdminApplication.class)
public class ScetcShowVideosAdminApplicationTests {

    private TestRestTemplate template = new TestRestTemplate();
	/**
	 * 测试方法执行前执行
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
	 * 测试方法执行后执行
	 */
	@After
	public void after() {
		System.out.println("-----执行测试完毕-----------");

	}

}
