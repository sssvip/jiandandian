package com.jdd.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.jdd.dao.impl.UserDao;
import com.jdd.model.User;
import com.jdd.until.MD5Until;
import com.jdd.until.TimerUtil;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  下午3:21:53
 */
public class UserDaoTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void userRegister(){
		TimerUtil.start();
		UserDao ud=new UserDao();
		User user=new User();
		user.setUser_name("admin");
		user.setUser_nickname("west");
		user.setUser_password("admin");
		user.setUser_phone("15388389933");
		user.setUser_type(2);
		String result=ud.register(user);
		System.out.println(result);
		TimerUtil.end();
	}
	@Test
	public void update(){
		TimerUtil.start();
		UserDao ud=new UserDao();
		User user=new User();
		user.setUser_id(15);
		user.setUser_name("admin");
		user.setUser_nickname("west");
		user.setUser_password("password");
		user.setUser_phone("15388389933");
		user.setUser_type(2);
		String result=ud.update(user);
		System.out.println(result);
		TimerUtil.end();
	}
	@Test
	public void findUserById(){
		TimerUtil.start();
		UserDao ud=new UserDao();
		User u=ud.findUserById(1);
		System.out.println(u);
		TimerUtil.end();
	}
	@Test
	public void login(){
		TimerUtil.start();
		UserDao ud=new UserDao();
		User u=ud.login("admin123","admin");
		System.out.println(u);
		TimerUtil.end();
	}
}
