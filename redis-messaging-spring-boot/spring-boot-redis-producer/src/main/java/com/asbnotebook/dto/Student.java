package com.asbnotebook.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

	private Integer id;
	private String name;
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy") 
	private LocalDate dob;
}
