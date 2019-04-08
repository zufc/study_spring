package com.study.spring.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.spring.pojo.User;
import com.study.spring.service.UserService;
import com.study.spring.test.SpringTestCase;

public class UserServiceTest extends SpringTestCase {

	@Autowired
	private UserService  userService;
	
	@Test
	public void selectUserByIdTest() {
		try {
			
			User user = userService.selectUserById("1");  
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
