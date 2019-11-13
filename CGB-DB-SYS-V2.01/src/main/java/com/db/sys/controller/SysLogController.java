package com.db.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.sys.service.SysLogService;

@Controller
@RequestMapping("/sysLog/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("doAjaxUI")
	public String doAjaxUI() {
		return "sysLog";
	}
	
	@RequestMapping("findLogs")
	@ResponseBody
	public List<Map<String, Object>> findLogs() {
		return sysLogService.findLogs();
	}
	
}
