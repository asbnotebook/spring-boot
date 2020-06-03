package com.asbnotebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asbnotebook.dto.Student;
import com.asbnotebook.jms.StudentProducer;

@SpringBootApplication
public class SpringBootActivemqProducerExampleApplication {

	@Autowired
	StudentProducer studentProducer;

	@Value("${activemq.destination}")
	private String destination;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActivemqProducerExampleApplication.class, args);
	}

	@RestController
	public class StudentController {

		@PostMapping("/")
		public String sendMessage(@RequestBody Student student) {
			studentProducer.sendTo(destination, student);
			return "success";
		}
	}
}