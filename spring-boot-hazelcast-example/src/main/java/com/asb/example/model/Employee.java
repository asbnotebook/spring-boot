package com.asb.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="emp_seq")
	@SequenceGenerator(name = "emp_seq", sequenceName = "employee_id_seq", allocationSize=1)
	@Column(name = "id")
	private Long id;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="employee_code")
	private String employeeCode;
	
	@Column(name="employee_name")
	private String employeeName;
}