package com.asbnotebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootDokcerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDokcerExampleApplication.class, args);
	}
	
	@RestController
	class HelloDocker{
		@GetMapping("/")
		public String getMessage() {
			return "Hello Docker!!";
		}
	}

}
