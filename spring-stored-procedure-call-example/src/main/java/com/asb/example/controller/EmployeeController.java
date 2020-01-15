package com.asb.example.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asb.example.model.Employee;

@RestController
public class EmployeeController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/emp-dtls")
	public ResponseEntity<List<Employee>> getEmp(@RequestParam(name = "name") String name) {
		List<Employee> employees = entityManager.createNamedStoredProcedureQuery("get_empoyee_details")
				.setParameter("emp_name", name).getResultList();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}