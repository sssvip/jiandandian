package com.jdd.test;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jdd.dao.impl.UserDao;
import com.jdd.model.User;
import com.jdd.until.MD5Until;
import com.jdd.until.TimerUtil;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  下午2:12:32
 */

public class MyTest {
	public static void main(String[] args) {
		TimerUtil.start();
		UserDao ud = new UserDao();
		User u = ud.findUserById(0);
		System.out.println(u);
		TimerUtil.end();
	}
}
