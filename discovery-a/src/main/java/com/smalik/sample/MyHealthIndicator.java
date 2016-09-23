package com.smalik.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

	private static Logger logger = LoggerFactory.getLogger(MyHealthIndicator.class);
	private int usage = 0;
	
	@Autowired
	private FloppyStatusMode floppyStatusMode;
	
	@Override
	public Health health() {
		++usage;
		if (!floppyStatusMode.isEnabled() || usage % 4 == 0) {
			logger.info("I am UP, usage=" + usage);
			return Health.up().build();
		} else {
			logger.info("I am DOWN, usage=" + usage);
			return Health.down().withDetail("Error Code", usage).build();
		}
	}
}