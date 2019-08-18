package com.asb.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@DefaultProperties(commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
@SpringBootApplication
@EnableCircuitBreaker
@RestController
public class SpringBootHystrixExampleApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/call-hystrix-client")
	@HystrixCommand
	public String method() {

		String response = restTemplate.getForObject("http://my-client/call-me/", String.class);
		return "Response : " + response;
	}

	@GetMapping("/call-hystrix-client-with-delay")
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "16000") })
	public String hystrixWithDelay() {

		String response = restTemplate.getForObject("http://my-client/call-me/", String.class);
		return "Response : " + response;
	}

	@GetMapping("/call-hystrix-client-with-fallback")
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") }, fallbackMethod = "fallBackMethod", threadPoolKey = "myServicePool", threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "40"),
					@HystrixProperty(name = "maxQueueSize", value = "10") })
	public String hystrixWithFallback() {

		String response = restTemplate.getForObject("http://my-client/call-me/", String.class);
		return "Response : " + response;
	}

	public String fallBackMethod() {

		return "Looks like my-client service is not reponding!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHystrixExampleApplication.class, args);
	}
}
