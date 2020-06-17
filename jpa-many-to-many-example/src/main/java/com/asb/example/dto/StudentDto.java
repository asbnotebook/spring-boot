package com.asb.example.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
	private Integer id;
	private String name;
	private Set<String> courses = new HashSet<>();
}
