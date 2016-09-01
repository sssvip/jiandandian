package com.jdd.dao;

import com.jdd.model.User;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  上午2:04:21
 */
public interface IUserDao {
	public User login(String username, String password);

	public String register(User user);

	public String update(User user);

	public User findUserById(int user_id);

}
