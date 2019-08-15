package com.asb.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("my-client")
public interface MyServiceFeignClient {

	@GetMapping("/call-me")
	public String method();
}
