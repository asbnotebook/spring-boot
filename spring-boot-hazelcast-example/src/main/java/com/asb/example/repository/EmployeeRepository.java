package com.asb.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asb.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}