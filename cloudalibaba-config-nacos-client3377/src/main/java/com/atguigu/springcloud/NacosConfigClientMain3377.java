package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377
{
	public static void main(String[] args) {
		SpringApplication.run(NacosConfigClientMain3377.class, args);
	}
}
//在你们的nacos目录下面新建/plugins/mysql目录，并把你们8+版本的mysql驱动jar包放到这个目录下面即可