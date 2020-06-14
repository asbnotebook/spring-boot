package com.asbnotebook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asbnotebook.entity.Student;
import com.asbnotebook.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") String id, @RequestBody Student student) {
		Optional<Student> std = studentRepository.findById(id);
		if (std.isPresent()) {
			Student studentDB = std.get();
			studentDB.setGrade(student.getGrade());
			studentDB.setName(student.getName());
			Student updatedStudent = studentRepository.save(studentDB);
			return new ResponseEntity<>(updatedStudent, HttpStatus.CREATED);
		}
		return null;
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") String id) {
		studentRepository.deleteById(id);
		return new ResponseEntity<>("Student with id:" + id + " deleted successfully", HttpStatus.OK);
	}
}