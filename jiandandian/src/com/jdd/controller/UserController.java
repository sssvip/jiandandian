package com.jdd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdd.dao.impl.UserDao;
import com.jdd.model.User;
import com.jdd.until.IsNull;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-16  下午9:20:31
 */

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "/add.do")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String json = request.getParameter("user");
			if (json == null || "".equals(json)) {
				// response.setStatus(500);
				json = "user is null";
				out.print(json);
			} else {
				ObjectMapper mapper = new ObjectMapper();
				User user = mapper.readValue(json, User.class);
				// System.out.println(user);
				UserDao userDao = new UserDao();
				String result = userDao.register(user);
				// response.setStatus(HttpStatus.SC_OK);
				out.print(result);
				out.flush();
			}
		} catch (IOException e) {
			System.out.println("get printWriter error");
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return;
	}

	@RequestMapping(value = "/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (IsNull.isNull(username) && IsNull.isNull(password)) {
				response.setStatus(500);
				out.print("args error");
				return;
			}
			// response.setStatus(200);
			//显示输出登录用户名及密码
			//System.out.println(username + "---" + password);
			UserDao ud = new UserDao();
			User u = ud.login(username, password);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(u);
			out.print(json);
			//输出User json数据
			//System.out.println(json);
			out.flush();
		} catch (IOException e) {

		} finally {
			if (out != null) {
				out.close();
			}
		}
		return;
	}

	// 不带参数地址 直接返回
	@RequestMapping(value = "/find.do", method = RequestMethod.GET)
	public void find(HttpServletRequest request, HttpServletResponse response) {
		UserDao ud = new UserDao();
		User u = ud.findUserById(1);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(u);
			out.flush();
		} catch (IOException e) {

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	// 带参数地址?json 直接返回json数据
	@RequestMapping(value = "/find.do", method = RequestMethod.GET, params = "json")
	@ResponseBody
	public User find(String json) {
		UserDao ud = new UserDao();
		return ud.findUserById(1);
	}
}
