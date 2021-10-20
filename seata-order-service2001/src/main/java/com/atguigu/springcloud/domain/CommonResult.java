package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //这里的T指的是泛型
public class CommonResult<T>
{
	private Integer code;
	private String  message;
	private T  data;

	public CommonResult(Integer code, String message)
	{
		this(code,message,null);
	}
}