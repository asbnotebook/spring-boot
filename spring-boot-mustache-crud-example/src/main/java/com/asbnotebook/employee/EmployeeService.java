package com.asbnotebook.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee, Integer id) {
		Employee emp = employeeRepository.getOne(id);
		emp.setName(employee.getName());
		return employeeRepository.save(emp);
	}

	public String deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
		return "Employee deleted successfully";
	}

	public Employee getEmployee(Integer id) {
		return employeeRepository.getOne(id);
	}
}
