package com.asb.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asb.example.model.Student;
import com.asb.example.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<Student> getAllStudents(@RequestBody Student student) {

		Student std = studentService.addStudent(student);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@PutMapping("/student")
	public ResponseEntity<Student> updateEmployee(@RequestBody Student student) {

		Student std = studentService.addStudent(student);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@DeleteMapping("/student")
	public ResponseEntity<String> deleteStudent(@RequestParam Integer studentId) {

		String message = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}