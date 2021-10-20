package com.atguigu.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
	//404 not_found
	private Integer code;
	private String message;
	private T data;

	//重载后只有两个参数的构造方法
	public CommonResult(Integer code, String message) {
		this(code, message, null);
	}
}
