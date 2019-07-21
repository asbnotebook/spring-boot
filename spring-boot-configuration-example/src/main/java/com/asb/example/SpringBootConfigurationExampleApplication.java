package com.asb.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootConfigurationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationExampleApplication.class, args);
	}

	@RestController
	public class AppController{
		
		private final AppConfig appConfig;

		@Autowired
		public AppController(AppConfig appConfig) {
		    this.appConfig = appConfig;
		}
		
		@GetMapping("/")
		public String getAppProps() {
			
			String response = "App Config Values: " + appConfig.toString() + "<br/>";
			return response;
		}
	}
}
