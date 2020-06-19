package com.asbnotebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asbnotebook.apiagent.StudentProducer;
import com.asbnotebook.dto.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentProducer studentProducer;

	@PostMapping("/send-message")
	public ResponseEntity<String> sendMessage(@RequestBody Student student) {
		studentProducer.sendMessage(student);
		return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
	}
}