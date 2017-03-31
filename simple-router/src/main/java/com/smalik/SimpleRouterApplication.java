package com.smalik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SimpleRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRouterApplication.class, args);
	}
}
