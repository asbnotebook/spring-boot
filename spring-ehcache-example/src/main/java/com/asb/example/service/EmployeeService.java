package com.asb.example.service;

import java.util.List;

import com.asb.example.model.Employee;

public interface EmployeeService {

	public Employee getEmployee(Long empId);
	public List<Employee> getAllEmployee();
	void deleteEmployee(Long empId);
	Employee updateEmployee(Employee emp);
	Employee createEmployee(Employee emp);
}