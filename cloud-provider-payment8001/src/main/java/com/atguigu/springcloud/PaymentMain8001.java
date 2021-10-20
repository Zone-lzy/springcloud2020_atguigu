package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lzy
 * 1.建立module
 * 2.该pom
 * 3.写YML
 * 4.主启动
 * 5.业务类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //表示的是开启服务发现的注解  -> 这个标签长期再用
public class PaymentMain8001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8001.class, args);
	}
}
