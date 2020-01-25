package com.asb.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.asb.example.model.Employee;
import com.asb.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Cacheable(value = "employeeCache", key="#id")
	public Optional<Employee> getEmployeeDetails(Long id) {
		return employeeRepository.findById(id);
	}

	@CachePut(value = "employeeCache", key = "#employee.id", unless = "#result=null")
	public Employee addEmployeeDetails(Employee employee) {
		return employeeRepository.save(employee);
	}

	@CacheEvict(value = "employeeCache", key = "#id")
	public String deleteEmployeeDetails(Long id) {
		employeeRepository.deleteById(id);
		return "Employee with id:" + id + " deleted successfully";
	}

	@CachePut(key = "#employee.id", value = "employeeCache", unless = "#result=null")
	public Employee updateEmployeeDetails(Employee employee) {
		return employeeRepository.save(employee);
	}
}