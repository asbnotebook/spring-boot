package com.asb.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="Student")
public class Student {

	@Id
	private String id;
	private String name;
	private String grade;
}