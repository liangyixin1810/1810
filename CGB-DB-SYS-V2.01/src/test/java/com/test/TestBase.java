package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	protected ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	
	@Test
	public void textCtx() {
		System.out.println(ctx);
	}
	@Test
	public void testProperties() {
		Object obj = ctx.getBean("cfg");
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
	}
	@After
	public void destory() {
		ctx.close();
	}
	
}
 