package com.asb.example.service;

import java.util.List;

import com.asb.example.model.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public List<Student> getAllStudents();

	public Student updateStudent(Student student);

	public String deleteStudent(Integer studentId);
}