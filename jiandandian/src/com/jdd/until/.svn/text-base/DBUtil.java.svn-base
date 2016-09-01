package com.jdd.until;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jdd.test.MyTest;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  下午4:27:31
 */
public class DBUtil {
	private final static String resource = "config/mybatisconf.xml";
	private static SqlSessionFactory sessionFactory;
	static {
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			// 构建sqlSession的工厂
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			System.out.println("mybatis load error!");
			e.printStackTrace();
		}
	}

	public static SqlSession createSession() {
		return sessionFactory.openSession(true);
	}

	public static void closeSession(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
