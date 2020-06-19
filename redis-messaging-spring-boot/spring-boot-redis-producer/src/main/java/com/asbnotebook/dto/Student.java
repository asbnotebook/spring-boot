package com.asbnotebook.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

	private Integer id;
	private String name;
	@JsonFormat(pattern = "dd/MM/yyyy") 
	private LocalDate dob;
}