package com.asbnotebook.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.asbnotebook.dto.Student;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StudentProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendTo(String destination, Student student) {
		jmsTemplate.convertAndSend(destination, student);
		log.info("Producer> Message Sent");
	}
}