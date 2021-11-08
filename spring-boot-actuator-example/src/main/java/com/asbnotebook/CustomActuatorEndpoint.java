package com.asbnotebook;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myapp")
public class CustomActuatorEndpoint {

	@ReadOperation
	public Map<String, String> myCustomreadEndpoint() {
		Map<String, String> map = new HashMap<>();
		map.put("readMessage", "This is cystom actuator endpoint.!!");
		return map;
	}

	@WriteOperation
	public Map<String, String> myCustomWriteEndpoint(String value) {

		Map<String, String> map = new HashMap<>();
		map.put("writeMessage", "This is cystom actuator write endpoint.!!" + value);
		return map;
	}

	@DeleteOperation
	public Map<String, String> myCustomDeleteEndpoint() {
		Map<String, String> map = new HashMap<>();
		map.put("readMessage", "This is cystom actuator delete endpoint.!!");
		return map;
	}
}
