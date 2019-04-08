package com.study.spring.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class User implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 6284013582186366710L;

	private String id;
	
	private String userId;
	
	private String userName;
	
	private String password;
	
	private Integer age;

	
	public User() {
		super();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		 try {
	            return JSON.toJSONString(this);
	        } catch (Exception e) {
	            return super.toString();
	        }
	}
	
	
	
}
