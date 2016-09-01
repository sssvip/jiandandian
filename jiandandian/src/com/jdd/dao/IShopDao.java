package com.jdd.dao;

import java.util.List;

import com.jdd.model.Order;
import com.jdd.model.User;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  上午2:04:21
 */
public interface IShopDao {

	public List<String> findShopNamesByShopId(int shop_id);

}
