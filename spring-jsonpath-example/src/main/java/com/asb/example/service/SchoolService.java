package com.asb.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SchoolService {

	@Autowired
	private JsonUtil jsonUtil;

	private static final ObjectMapper om = new ObjectMapper();

	public String getDetails() throws JsonProcessingException {

		return om.writeValueAsString(jsonUtil.getSchoolDetails());
	}
}