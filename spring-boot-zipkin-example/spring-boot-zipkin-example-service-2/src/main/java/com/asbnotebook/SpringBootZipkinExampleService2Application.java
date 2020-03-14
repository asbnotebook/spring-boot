package com.asbnotebook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootZipkinExampleService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZipkinExampleService2Application.class, args);
	}

}

@RestController
class ExampleController2 {
	
	private static final Log log = LogFactory.getLog(ExampleController2.class);
			
	@GetMapping("/test2")
	public String testZipkin() {
		log.info("calling service 2!!");
		return "working 2!!";
	}
}