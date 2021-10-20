package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lzy
 */
// 推荐使用 ，尽量减少在到层中用repository
//@Repository
@Mapper
public interface PaymentDao {
	//写两个主流的操作，
	public int create(Payment payment);
	public Payment getPaymentById(@Param("id")Long id);
}
