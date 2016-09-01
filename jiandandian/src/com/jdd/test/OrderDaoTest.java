package com.jdd.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.jdd.dao.impl.OrderDao;
import com.jdd.model.Order;
import com.jdd.until.TimerUtil;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  下午3:21:53
 */
public class OrderDaoTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void userRegister(){
		TimerUtil.start();
		OrderDao dao =new  OrderDao();
		List<Order> list=dao.findOrdersByUserId(1);
		for (Order order : list) {
			System.out.println(order);
		}
		TimerUtil.end();
	}
}
