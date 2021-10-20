package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lzy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
	//序列化，在分布式的时候可能用的到
	private Long id;
	private String serial;
}
