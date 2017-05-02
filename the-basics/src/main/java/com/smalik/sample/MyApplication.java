package com.smalik.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApplication.class, args);
	}

	@Bean
	@Profile("default")
	public MessageService createDevservice() {
		return new MessageService() {
			public String getMessage() {
				return "Get back to work";
			}
		};
	}

	@Bean
	@Profile("cloud")
	public MessageService createCloudservice() {
		return new MessageService() {
			public String getMessage() {
				return "I am in the CLOUD";
			}
		};
	}
}
