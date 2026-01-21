package com.asb.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asb.example.model.Employee;
import com.asb.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee emp) {
		if(emp!=null){
		return employeeRepository.save(emp);
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		if(emp!=null){
		return employeeRepository.update(emp);
		}
	}

	@Override
	public Employee getEmployee(Long empId) {
		Employee Emp =  employeeRepository.findById(empId).get();
		if(Emp.isPresent()) {
			return Emp.get();
		}
		return null;
	}

	@Override
	public void deleteEmployee(Long empId) {
		if(!employeeRepository.findById(empId).isEmpty()){
		employeeRepository.deleteById(empId);
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
