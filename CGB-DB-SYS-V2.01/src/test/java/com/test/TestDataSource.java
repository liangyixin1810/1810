package com.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

public class TestDataSource extends TestBase{
	@Test
	public void testDruidDataSource() throws Exception {
		//连接池对象
		DataSource ds = 
				ctx.getBean("dataSource",DataSource.class);
		System.out.println(ds.getConnection());
	}
}
