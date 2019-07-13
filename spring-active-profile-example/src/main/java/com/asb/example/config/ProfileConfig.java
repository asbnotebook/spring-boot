package com.asb.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Profile("DEV")
	@Bean(name = "myBean")
	public String createDevBean() {
		return "My bean is configured with Development configurations!!";
	}

	@Profile("PROD")
	@Bean(name = "myBean")
	public String createProdBean() {
		return "My bean is configured with Production configurations!!";
	}
}