package com.jdd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jdd.dao.IOrderDao;
import com.jdd.model.Order;
import com.jdd.until.DBUtil;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-7-19  上午9:31:39
 */
public class OrderDao implements IOrderDao {

	public List<Order> findOrdersByUserId(int user_id) {
		SqlSession sqlsession = null;
		sqlsession = DBUtil.createSession();
		List<Order> list = sqlsession.selectList(Order.class.getName()
				+ ".findOrdersByUserId", user_id);
		return list;
	}

}
