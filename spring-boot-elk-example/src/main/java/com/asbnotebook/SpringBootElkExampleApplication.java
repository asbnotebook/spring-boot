package com.asbnotebook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootElkExampleApplication {
	
	private static Log log = LogFactory.getLog(SpringBootElkExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElkExampleApplication.class, args);
	}

	@GetMapping("/test")
	public String testELK() {
		log.info("Inside test ELK!!");
		return "Hello!!";
	}
}
