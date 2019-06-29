package com.asb.example.service;

import java.util.List;

import com.asb.example.model.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public Employee getEmployee(Long empId);
	public void deleteEmployee(Long empId);
	public List<Employee> getAllEmployee();
}

