package com.asb.example.resource;

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
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student s = studentService.saveStudent(student);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student s = studentService.updateStudent(student);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@DeleteMapping("/student")
	public ResponseEntity<String> deleteStudent(@RequestParam(name = "id") String id) {
		String message = studentService.getStudent(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}