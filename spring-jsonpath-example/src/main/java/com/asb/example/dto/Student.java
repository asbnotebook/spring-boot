package com.asb.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	private String firstName;
	private String lastName;
	private Grade grade;
}