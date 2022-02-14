package com.asbnotebook.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asbnotebook.example.dto.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Student resources that provides access to availabe student data", 
	name = "Student Resource")
@RestController("/")
public class StudentController {

	@Operation(summary = "Get students", 
			description = "Provides all available students list")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", 
					description = "${api.response-codes.ok.desc}"),
			@ApiResponse(responseCode = "400", 
					description = "${api.response-codes.badRequest.desc}", 
					content = { @Content(examples = { @ExampleObject(value = "") }) }),
			@ApiResponse(responseCode = "404", 
					description = "${api.response-codes.notFound.desc}", 
					content = { @Content(examples = { @ExampleObject(value = "") }) }) })
	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();
		
		Student student = new Student();
		student.setId(1L);
		student.setName("Arun");
		students.add(student);

		return students;
	}
}
