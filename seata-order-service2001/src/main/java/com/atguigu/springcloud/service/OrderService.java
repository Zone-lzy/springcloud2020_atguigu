package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderService
{
	void create(Order order);
}
