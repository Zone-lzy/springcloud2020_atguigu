package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes(); //类似yml中的routes
		routes.route("path_route_atguigu",
				r -> r.path("/guonei")
						.uri("http://news.baidu.com")).build();

		routes.route("path_route_atguigu2",
				r -> r.path("/guoji")
						.uri("http://news.baidu.com")).build();

		return routes.build();
	}


}
