package com.asb.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asb.example.model.Employee;
import com.asb.example.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<Employee> getEmployeeDetails(@RequestParam(name = "id") Long id) {

		Optional<Employee> emp = employeeService.getEmployeeDetails(id);
		return new ResponseEntity<>((emp.isPresent() ? emp.get() : null), HttpStatus.OK);
	}

	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.updateEmployeeDetails(employee), HttpStatus.CREATED);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployeeDetails(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployeeDetails(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/employees")
	public ResponseEntity<String> deleteEmployeeDetails(@RequestParam(name = "id") Long id) {
		return new ResponseEntity<>(employeeService.deleteEmployeeDetails(id), HttpStatus.OK);
	}
}