package com.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.db.sys.dao.SysLogDao;

public class TestMyBatis extends TestBase {
	@Test
	public void testSqlSessionFactory() {
		SqlSessionFactory factory = 
				ctx.getBean("sqlSessionFactory",
						SqlSessionFactory.class);
		System.out.println(factory);
	}
	@Test
	public void testSqlSession() {
		SqlSessionFactory factory = 
				ctx.getBean("sqlSessionFactory",
						SqlSessionFactory.class);
		SqlSession session = factory.openSession();
		String statement=
				"com.db.sys.dao.SysLogDao.findLogs";
		List<Map<String,Object>> list = session.selectList(statement);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		session.close();
	}
	@Test
	public void testSqlSession1() {
		SysLogDao dao = 
				ctx.getBean("sysLogDao",SysLogDao.class);
		List<Map<String,Object>> list = dao.findLogs();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
}
