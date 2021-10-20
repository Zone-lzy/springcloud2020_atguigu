package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.Ib.LoadBalancer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
//import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.security.auth.login.Configuration;
import java.net.URI;
import java.util.List;

/**
 * @author lzy
 */
@RestController
@Slf4j
public class OrderController {
	//两个服务之间调用  httpClient 、
	//  	restTemplate: 提供了多种便捷的访问远程Http服务的方法，是一种简单便捷的访问restful服务模板类，是spring提供的用于访问Rest服务的客户端模板工具类。
	//      调用接口方式封装。(url, resultMap, ResponseBean.class)， 分别代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	//不能写死，
//	public static final String PAYMENT_URL = "http://localhost:8001";
//	CLOUD-PAYMENT-SERVICE 为注册的application名称
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private LoadBalancer loadBalancer;

	@Resource
	private DiscoveryClient discoveryClient;

	@Resource
	private RestTemplate restTemplate;

	@GetMapping(value = "/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping(value = "/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		System.out.println("12346");
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

	@GetMapping(value = "/consumer/payment/getForEntity/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
		System.out.println("333333");
		ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
		if(forEntity.getStatusCode().is2xxSuccessful()) {
			return forEntity.getBody();
		} else {
			return new CommonResult<>(444, "操作失败");
		}
	}

	@GetMapping(value = "/consumer/payment/lb")
	public String getPaymentLB()
	{
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

		if(instances == null || instances.size() <= 0){
			return null;
		}

		ServiceInstance serviceInstance = loadBalancer.instances(instances);
		URI uri = serviceInstance.getUri();
		return restTemplate.getForObject(uri+"/payment/lb",String.class);
	}

	// ====================> zipkin+sleuth
	@GetMapping("/consumer/payment/zipkin")
	public String paymentZipkin()
	{
		String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
		return result;
	}

}
