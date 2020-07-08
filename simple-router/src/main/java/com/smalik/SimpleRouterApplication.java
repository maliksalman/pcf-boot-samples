package com.smalik;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SimpleRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRouterApplication.class, args);
	}

	@Bean
	public MeterRegistryCustomizer<MeterRegistry> commonTagsRegistryCustomizer() {
		return new MeterRegistryCustomizer<MeterRegistry>() {
			@Override
			public void customize(MeterRegistry registry) {
				registry.config().commonTags("application", "simple-router");
			}
		};
	}
}
