package com.asbnotebook.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.asbnotebook.dto.Student;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StudentConsumer {

	@JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
	public void processToDo(Student student) {
		log.info("Consumer> " + student);
	}
}