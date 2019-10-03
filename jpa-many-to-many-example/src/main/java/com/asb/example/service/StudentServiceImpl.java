package com.asb.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asb.example.model.Student;
import com.asb.example.repo.CourseRepository;
import com.asb.example.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentRepository studentRepository;

	@Resource
	private CourseRepository courseRepository;

	@Override
	public Student addStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student) {

		Student std = studentRepository.getOne(student.getId());
		if (null != std) {

			std = student;
			return studentRepository.save(std);
		} else {

			return null;
		}
	}

	@Override
	public String deleteStudent(Integer studentId) {

		studentRepository.deleteById(studentId);
		return "Student with id: " + studentId + " deleted successfully!";
	}
}