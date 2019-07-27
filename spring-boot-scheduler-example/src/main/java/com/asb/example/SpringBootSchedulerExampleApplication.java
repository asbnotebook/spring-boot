package com.asb.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSchedulerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerExampleApplication.class, args);
	}
}