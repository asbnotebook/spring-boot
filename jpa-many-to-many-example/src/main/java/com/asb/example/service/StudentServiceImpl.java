package com.asb.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asb.example.dto.StudentDto;
import com.asb.example.model.Course;
import com.asb.example.model.Student;
import com.asb.example.repo.CourseRepository;
import com.asb.example.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentRepository studentRepository;

	@Resource
	private CourseRepository courseRepository;

	@Transactional
	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		Student student = new Student();
		mapDtoToEntity(studentDto, student);
		Student savedStudent = studentRepository.save(student);
		return mapEntityToDto(savedStudent);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<StudentDto> studentDtos = new ArrayList<>();
		List<Student> students = studentRepository.findAll();
		students.stream().forEach(student -> {
			StudentDto studentDto = mapEntityToDto(student);
			studentDtos.add(studentDto);
		});
		return studentDtos;
	}

	@Transactional
	@Override
	public StudentDto updateStudent(Integer id, StudentDto studentDto) {
		Student std = studentRepository.getOne(id);
		std.getCourses().clear();
		mapDtoToEntity(studentDto, std);
		Student student = studentRepository.save(std);
		return mapEntityToDto(student);
	}

	@Override
	public String deleteStudent(Integer studentId) {
		
		Student student = studentRepository.getOne(studentId);
		//Remove the related courses from student entity.
		student.removeCourses();
		studentRepository.deleteById(studentId);
		return "Student with id: " + studentId + " deleted successfully!";
	}

	private void mapDtoToEntity(StudentDto studentDto, Student student) {
		student.setName(studentDto.getName());
		if (null == student.getCourses()) {
			student.setCourses(new HashSet<>());
		}
		studentDto.getCourses().stream().forEach(courseName -> {
			Course course = courseRepository.findByName(courseName);
			if (null == course) {
				course = new Course();
				course.setStudents(new HashSet<>());
			}
			course.setName(courseName);
			student.addCourse(course);
		});
	}

	private StudentDto mapEntityToDto(Student student) {
		StudentDto responseDto = new StudentDto();
		responseDto.setName(student.getName());
		responseDto.setId(student.getId());
		responseDto.setCourses(student.getCourses().stream().map(Course::getName).collect(Collectors.toSet()));
		return responseDto;
	}
}
