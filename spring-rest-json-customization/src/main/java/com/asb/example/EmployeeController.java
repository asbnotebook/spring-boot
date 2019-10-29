package com.asb.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/get-json")
	public ResponseEntity<EmployeeDTO> getObject() {
		EmployeeDTO dto = new EmployeeDTO(1, "Arun", new Date() ,LocalDate.now(), LocalDateTime.now());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}