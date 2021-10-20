package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzy
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
//	@LoadBalanced //开启负载均衡机制，默认是不开启的，需要使用注解的方式赋予RestTemplate负载均衡的能力，开启后采用默认的轮询的方式进行
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
