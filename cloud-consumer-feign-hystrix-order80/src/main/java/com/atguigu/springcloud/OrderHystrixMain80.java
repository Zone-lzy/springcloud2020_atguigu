package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 */
@SpringBootApplication
@EnableFeignClients  //激活客户端的Feign，服务调用  接口+注解的形式
@EnableHystrix
//@EnableHystrix
public class OrderHystrixMain80
{
	public static void main(String[] args)
	{
		SpringApplication.run(OrderHystrixMain80.class,args);
	}
}
