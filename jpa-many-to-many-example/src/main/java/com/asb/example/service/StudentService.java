package com.asb.example.service;

import java.util.List;

import com.asb.example.dto.StudentDto;

public interface StudentService {

	public StudentDto addStudent(StudentDto studentDto);

	public List<StudentDto> getAllStudents();

	public StudentDto updateStudent(Integer studentId, StudentDto student);

	public String deleteStudent(Integer studentId);
}
