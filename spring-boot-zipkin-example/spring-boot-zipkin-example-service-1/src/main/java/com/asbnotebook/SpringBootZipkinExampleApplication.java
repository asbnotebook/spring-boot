package com.asbnotebook;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootZipkinExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZipkinExampleApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

@RestController
class ExampleController {

	@Autowired
	private RestTemplate restTemplate;

	private static final Log log = LogFactory.getLog(ExampleController.class);

	@GetMapping("/test")
	public String testZipkin() throws URISyntaxException {
		log.info("calling service!!");
		String message = restTemplate.getForObject(new URI("http://localhost:8081/test2"), String.class);
		log.info("message from service 2: " + message);
		return "working!!";
	}
}