package com.asb.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients(value="com.asb.example")
@RestController
public class SpringBootFeignClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFeignClientExampleApplication.class, args);
	}

	@Autowired
	MyServiceFeignClient myServiceFeignClient;

	@GetMapping("/call-eureka-client")
	public String method() {

		String response = myServiceFeignClient.method();
		return "Response : " + response;
	}
}
