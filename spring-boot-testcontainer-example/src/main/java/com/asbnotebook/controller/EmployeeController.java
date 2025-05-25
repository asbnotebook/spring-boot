package com.asbnotebook.controller;

import com.asbnotebook.entity.Employee;
import com.asbnotebook.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        var employees = employeeRepository.findAll().stream()
                .map(entityToDto())
                .collect(Collectors.toList());
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    private static Function<Employee, EmployeeDto> entityToDto() {
        return employee -> EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .salary(employee.getSalary()).build();
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {
        log.info("Post request called with EmployeeDTO: {}", employeeDto);
        var employee = Employee.builder()
                .name(employeeDto.getName())
                .salary(employeeDto.getSalary())
                .build();
        var empFromDb = employeeRepository.save(employee);
        employeeDto.setId(empFromDb.getId());
        log.info("Created employee in DB: {}", employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> save(@PathVariable("id") Long empId) {
        log.info("Delete request for employeeID:{}", empId);
        employeeRepository.deleteById(empId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
