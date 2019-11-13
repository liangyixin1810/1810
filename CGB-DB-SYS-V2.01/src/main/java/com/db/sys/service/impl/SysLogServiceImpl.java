package com.db.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.sys.dao.SysLogDao;
import com.db.sys.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService{
	@Autowired
	private SysLogDao sysLogDao;
	@Override
	public List<Map<String, Object>> findLogs() {
		long t1 = System.currentTimeMillis();
		List<Map<String, Object>> list = 
				sysLogDao.findLogs();
		long t2 = System.currentTimeMillis();
		System.out.println("execute time:"+(t2-t1));
		return list;
	}

}
