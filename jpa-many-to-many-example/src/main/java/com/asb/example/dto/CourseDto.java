package com.asb.example.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Data
public class CourseDto {
	private Integer id;
	private String name;
	Set<String> students = new HashSet<>();
}
