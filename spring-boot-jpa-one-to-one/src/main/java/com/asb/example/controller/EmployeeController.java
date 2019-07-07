package com.asb.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asb.example.model.Employee;
import com.asb.example.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(consumes = "application/json", produces = "application/json", path = "/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<>(employeeService.createEmployee(emp), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json", produces = "application/json", path = "/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<>(employeeService.updateEmployee(emp), HttpStatus.CREATED);
	}

	@DeleteMapping(produces = "application/json", consumes = "text/plain", path = "/employee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value="empId") Long empId) {
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<>("Employee with EmployeeId : " + empId + " deleted successfully", HttpStatus.OK);
	}

	@GetMapping(path = "/employee/{empId}", produces = "application/json")
	public ResponseEntity<Employee> getEmployee(@PathVariable(value = "empId") Long empId) {
		return new ResponseEntity<>(employeeService.getEmployee(empId), HttpStatus.OK);
	}

	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
	}


}
