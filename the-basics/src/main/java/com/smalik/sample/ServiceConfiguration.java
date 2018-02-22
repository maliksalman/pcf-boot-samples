package com.smalik.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ServiceConfiguration {

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
