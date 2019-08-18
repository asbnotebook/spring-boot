package com.asb.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringBootEurekaClientApplication {

	@GetMapping("/call-me")
	public String method() throws InterruptedException {
		
		Thread.sleep(11000);
		return "You are calling me through service discovery!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaClientApplication.class, args);
	}
}
