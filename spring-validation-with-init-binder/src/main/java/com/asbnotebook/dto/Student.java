package com.asbnotebook.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer grade;
	private Boolean address;
	private Address addressDetails;
}