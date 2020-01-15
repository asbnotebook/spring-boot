package com.asb.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@NamedStoredProcedureQuery(name = "get_empoyee_details", procedureName = "get_empoyee_details", resultClasses = {
		Employee.class }, parameters = {
				@StoredProcedureParameter(name = "emp_name", mode = ParameterMode.IN, type = String.class) })
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "designation")
	private String designation;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_code")
	private String employeeCode;
}