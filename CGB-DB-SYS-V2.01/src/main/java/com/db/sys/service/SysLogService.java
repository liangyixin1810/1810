package com.db.sys.service;

import java.util.List;
import java.util.Map;

public interface SysLogService {
	public List<Map<String,Object>> findLogs();
}
