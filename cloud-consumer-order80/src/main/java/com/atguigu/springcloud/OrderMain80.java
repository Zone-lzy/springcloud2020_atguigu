package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lzy
 */
@SpringBootApplication
@EnableEurekaClient  //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class) //访问的服务，，，不要用默认的，用我自己定义的
public class OrderMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain80.class, args);
	}
}
