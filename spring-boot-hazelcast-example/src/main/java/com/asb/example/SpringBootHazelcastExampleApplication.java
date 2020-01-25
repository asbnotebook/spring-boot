package com.asb.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootHazelcastExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHazelcastExampleApplication.class, args);
	}
}