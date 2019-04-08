package com.study.spring.dao;

import com.study.spring.pojo.User;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author zufeichao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserDao {

	public User selectUserById(String id);
}
