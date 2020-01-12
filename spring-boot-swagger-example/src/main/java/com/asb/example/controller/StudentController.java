package com.asb.example.controller;

import java.util.List;

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

import com.asb.example.model.Student;
import com.asb.example.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ApiOperation(value = "Find Students", notes = "${StudentController.findStudents}")
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@ApiOperation(value = "Save Student", notes = "${StudentController.saveStudent}")
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent(
			@ApiParam(name = "Save Student", value = "Student Details to be saved", required = true) @RequestBody Student student) {
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Students", notes = "${StudentController.updateStudents}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Saved"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource is not found") })
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(
			@ApiParam(name = "Update Student", value = "Student Details to be updated", required = true) @RequestBody Student student) {
		return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Delete Student By ID", notes = "${StudentController.deleteStudentById}")
	@DeleteMapping("/student/{student-id}")
	public ResponseEntity<Student> deleteStudent(
			@ApiParam(name = "Delete Student", value = "Id of Student to be deleted", required = true) @PathVariable(name = "student-id") Long studentId) {
		return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
	}
}