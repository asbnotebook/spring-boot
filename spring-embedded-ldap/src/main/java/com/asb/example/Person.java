package com.asb.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
	
	private String userId;
	private String fullName;
	private String lastName;
	private String description;
}