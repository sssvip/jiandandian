package com.jdd.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdd.until.MessageUtil;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-20  上午12:16:20
 */
public class SendMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String result = "error";
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		String check = request.getParameter("check");
		if (!check.equals("david")) {
			result = "user identity  error";
			out.print(result);
		} else if (phone == null || "".equals(phone)) {
			result = "phone num is null";
			out.print(result);
		} else if (code == null || "".equals(code)) {
			result = "code num is null";
			out.print(result);
		} else {
			result = MessageUtil.sendMassage(phone, code);
			out.print(result);
			//System.out.println(result);
		}
		out.flush();
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
