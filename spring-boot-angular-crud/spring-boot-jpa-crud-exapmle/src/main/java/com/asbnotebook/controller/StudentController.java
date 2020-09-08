package com.asbnotebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asbnotebook.model.Student;
import com.asbnotebook.repo.StudentRepository;

@CrossOrigin(origins = {"*"})
@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students/")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentRepository.findAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/students/")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student std = studentRepository.save(student);
		return new ResponseEntity<>(std, HttpStatus.OK);
	}

	@PutMapping("/students/")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Optional<Student> std = studentRepository.findById(student.getId());
		Student stdUpdated = std.get();
		stdUpdated.setGrade(student.getGrade());
		stdUpdated.setName(student.getName());
		Student studentUpdated = studentRepository.save(stdUpdated);
		return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> createStudent(@PathVariable(name = "id") Long id) {
		studentRepository.deleteById(id);
		return new ResponseEntity<>("student id: "+ id + " deleted successfully", HttpStatus.OK);
	}
}