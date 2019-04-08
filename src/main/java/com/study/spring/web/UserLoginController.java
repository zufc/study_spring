package com.study.spring.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.spring.pojo.User;
import com.study.spring.service.UserService;
import com.study.spring.util.JsonBean;

@Controller
@RequestMapping(value = "/user/p")
public class UserLoginController extends BaseController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/login.action")
	public JsonBean userLogin(HttpServletRequest request) {
		JsonBean json = new JsonBean();
		Map<String,Object> params =getParams();
		logger.debug("用户登录开始params={}",new Object[] {params});
		User user = userService.selectUserById(MapUtils.getString(params, "id",null));
		json.setData(user);
		return json;
	}
	
  }
