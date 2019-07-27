package com.asb.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCommandLineRunnerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCommandLineRunnerExampleApplication.class, args);
	}

	@Bean
	public StartupRunner StartupRunner() {
		return new StartupRunner();
	}
}
