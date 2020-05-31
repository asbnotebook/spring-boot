package com.asbnotebook.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void createStudent(Student student) {
		studentRepository.save(student);
	}

	public void updateStudent(Student student, Integer id) {
		Student std = studentRepository.getOne(id);
		std.setName(student.getName());
		studentRepository.save(std);
	}

	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}

	public Student getStudent(Integer id) {
		return studentRepository.getOne(id);
	}
}