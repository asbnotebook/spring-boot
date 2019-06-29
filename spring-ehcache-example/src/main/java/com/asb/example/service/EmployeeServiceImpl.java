package com.asb.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.asb.example.model.Employee;
import com.asb.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CacheManager cacheManager;

	@Override
	@CachePut(value = "employeeCache", key = "#result.id")
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	@Cacheable(value = "employeeCache", key = "#empId", unless = "#result=null")
	public Employee getEmployee(Long empId) {
		Optional<Employee> optionalEmp = employeeRepository.findById(empId);
		if (optionalEmp.isPresent()) {
			return optionalEmp.get();
		}
		return null;
	}

	@Override
	@CacheEvict(value = "employeeCache", key = "#empId")
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}

	@Override
	@CachePut(value = "employeeCache", key = "#emp.id")
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		for (Employee emp : employees) {
			addToCache(emp);
		}
		return employees;
	}

	public void addToCache(Employee emp) {
		Cache cache = cacheManager.getCache("employeeCache");
		cache.putIfAbsent(emp.getId(), emp);
	}
}