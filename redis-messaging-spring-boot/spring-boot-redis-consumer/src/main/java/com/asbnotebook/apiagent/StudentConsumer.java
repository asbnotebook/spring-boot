package com.asbnotebook.apiagent;

import org.springframework.stereotype.Component;

import com.asbnotebook.dto.Student;

@Component
public class StudentConsumer {

	public void handleMessage(Student student) {
		System.out.println("Consumer> " + student);
	}
}