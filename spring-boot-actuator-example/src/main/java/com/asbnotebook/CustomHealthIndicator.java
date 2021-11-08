package com.asbnotebook;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("myapp")
public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		int errorCode = check();
		if (errorCode != 0) {
			return Health.down().withDetail("Custom service is down!!", errorCode).build();
		}
		return Health.up().build();
	}

	private int check() {
		Random random = new Random();
		int n = random.nextInt(10);
		return n % 2;
	}
}