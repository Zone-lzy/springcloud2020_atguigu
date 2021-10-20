package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


//这个接口与spring无关，与rabbitmq有关
@EnableBinding(Source.class) // 定义消息推送的管道，源管道
public class MessageProviderImpl implements IMessageProvider {

	@Resource
	private MessageChannel output;

	@Override
	public String send() {
		String serial = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(serial).build());
		System.out.println("**************serial: " + serial);
		return null;
	}
}
