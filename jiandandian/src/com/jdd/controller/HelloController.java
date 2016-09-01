package com.jdd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-16  下午9:20:31
 */
@Controller
@RequestMapping("/test")
public class HelloController {
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		request.setAttribute("hello", "world");
		return "hello";
	}
}
