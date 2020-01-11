package com.asb.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asb.example.dto.Student;
import com.asb.example.service.SchoolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	private static final ObjectMapper om = new ObjectMapper();

	@GetMapping("/get-school-details")
	public ResponseEntity<String> getSchoolDetails() throws JsonProcessingException {
		return new ResponseEntity<>(schoolService.getDetails(), HttpStatus.OK);
	}

	@GetMapping("/get-students")
	public ResponseEntity<String> getStudentDetails() throws JsonProcessingException {
		String json = schoolService.getDetails();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
		List<Student> students = JsonPath.read(document, "$.students");
		return new ResponseEntity<>(om.writeValueAsString(students), HttpStatus.OK);
	}

	@GetMapping("/get-student-names")
	public ResponseEntity<String> getStudentNames() throws JsonProcessingException {
		String json = schoolService.getDetails();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
		List<String> students = JsonPath.read(document, "$.students[*].firstName");
		return new ResponseEntity<>(om.writeValueAsString(students), HttpStatus.OK);
	}

	@GetMapping("/student-count")
	public ResponseEntity<Integer> getStudentCount() throws JsonProcessingException {
		String json = schoolService.getDetails();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
		Integer count = JsonPath.read(document, "$.students.length()");
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	@GetMapping("/student/{firstName}")
	public ResponseEntity<List<Student>> getStudentCount(@PathVariable(value="firstName") String firstName) throws JsonProcessingException {
		String json = schoolService.getDetails();
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
		List<Student> students = JsonPath.read(document, "$..[?(@.firstName=='" + firstName + "')]");
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
}
