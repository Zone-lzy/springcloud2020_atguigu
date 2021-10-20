package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper  //这里记得每次在写的时候，及时的加上，避免不必要的错误以及时间的浪费
public interface OrderDao
{
	//1 新建订单
	void create(Order order);

	//2 修改订单状态，从零改为1
	void update(@Param("userId") Long userId,@Param("status") Integer status);
}