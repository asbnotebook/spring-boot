package com.asbnotebook.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

	private Integer id;
	private String name;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
}