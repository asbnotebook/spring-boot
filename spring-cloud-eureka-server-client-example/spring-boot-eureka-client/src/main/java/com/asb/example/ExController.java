package com.asb.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExController {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/serviceinfo")
	public String meth() {
		
		return template.getForObject("http://localhost:8081/serviceInfo/", String.class);
	}
	
	@GetMapping("/")
	public String method() {
		return "You are calling me through service discovery!!";
	}

}
