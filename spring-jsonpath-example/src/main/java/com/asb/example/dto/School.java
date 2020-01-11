package com.asb.example.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class School {
	private String name;
	List<Student> students = new ArrayList<>();
}