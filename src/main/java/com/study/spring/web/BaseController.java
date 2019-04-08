package com.study.spring.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.study.spring.util.NetWorkUtil;
import com.study.spring.util.ParamsUtil;

public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Map<String, Object> getParams() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Map<String, Object> initParams = ParamsUtil.handleServletParameter(request);
		initParams.put("IP", NetWorkUtil.getRemortIP(request));
		return initParams;
	}
}
