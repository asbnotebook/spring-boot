package com.asb.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asb.example.model.Student;
import com.asb.example.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student saveStudent(Student student){
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student){
		return studentRepository.save(student);
	}
	
	public Student deleteStudent(Long studentId){
		Student student = studentRepository.getOne(studentId);
		studentRepository.delete(student);
		return student;
	}
}