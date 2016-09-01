package com.jdd.dao.impl;

import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.jdd.dao.IUserDao;
import com.jdd.model.User;
import com.jdd.until.DBUtil;
import com.jdd.until.IsNull;
import com.jdd.until.MD5Until;
/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  上午2:05:03
 */
@Repository
public class UserDao implements IUserDao {

	public User login(String username, String password) {
		SqlSession session = null;
		User user = null;
		try {
			User u = new User();
			u.setUser_name(username);
			u.setUser_password(MD5Until.toMd5(password));
			session = DBUtil.createSession();
			user = session.selectOne(User.class.getName() + ".login", u);
		} finally {
			DBUtil.closeSession(session);
		}
		return user;
	}

	public String register(User user) {
		SqlSession session = null;
		String result = "";
		try {
			session = DBUtil.createSession();
			// 判断用户名是否已经存在
			String tempresult = session.selectOne(User.class.getName()
					+ ".findUserByName", user.getUser_name());
			if (!(tempresult == null || "".equals(tempresult))) {
				result = "user exsisted";
			} else {
				// 密码加密处理
				user.setUser_password(MD5Until.toMd5(user.getUser_password()));
				//用户昵称初始化
				if(IsNull.isNull(user.getUser_nickname())){
					user.setUser_nickname("用户"+new Random().nextInt(10000));
				}
				//默认用户类型
				if(IsNull.isNull(user.getUser_type())){
					user.setUser_type(1);
				}
				// 不存在则插入用户
				session.insert(User.class.getName() + ".register", user);
				session.commit();
				result = "success";
			}
		} finally {
			DBUtil.closeSession(session);
		}
		return result;
	}

	public String update(User user) {
		SqlSession session = null;
		String result = "";
		try {
			session = DBUtil.createSession();
			user.setUser_password(MD5Until.toMd5(user.getUser_password()));
			int status = session.update(User.class.getName() + ".update", user);
			if (status == 1) {
				session.commit();
				result = "success";
			} else {
				session.rollback();
				result = "update failed";
			}
		} finally {
			DBUtil.closeSession(session);
		}
		return result;
	}

	public User findUserById(int user_id) {
		SqlSession session = null;
		User u = null;
		try {
			session = DBUtil.createSession();
			u = session.selectOne(User.class.getName() + ".findUserById",
					user_id);
		} finally {
			DBUtil.closeSession(session);
		}
		return u;
	}
	public User findUserByName(String user_name) {
		SqlSession session = null;
		User u = null;
		try {
			session = DBUtil.createSession();
			u = session.selectOne(User.class.getName() + ".findUserByName",
					user_name);
		} finally {
			DBUtil.closeSession(session);
		}
		return u;
	}

}
