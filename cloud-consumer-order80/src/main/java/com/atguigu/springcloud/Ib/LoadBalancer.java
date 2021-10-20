package com.atguigu.springcloud.Ib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
	public ServiceInstance instances(List<ServiceInstance> serviceInstance);
}
