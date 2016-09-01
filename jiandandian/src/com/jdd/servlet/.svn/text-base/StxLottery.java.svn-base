package com.jdd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 *@Time:2016-6-27  上午2:24:27
 */

public class StxLottery extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String result = "error";
		String random_code = request.getParameter("random_code");
		String right_random_code = request.getParameter("right_random_code");
		String check = request.getParameter("check");
		if (check==null||(!check.equals("david"))) {
			result = "user identity  error";
			out.print(result);
		} else if (random_code == null || "".equals(random_code)) {
			result = "random_code num is null";
			out.print(result);
		}else if (right_random_code == null || "".equals(right_random_code)) {
			result = "right_random_code num is null";
			out.print(result);
		} else {
			// result = MessageUtil.sendMassage(phone, code);
			// /out.print(result);
			int pre_num=new Random().nextInt(89)+10;
			System.out.println("十期验证码是："+pre_num+"" + random_code+"\n十一期验证码是："+pre_num+""+right_random_code);
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
