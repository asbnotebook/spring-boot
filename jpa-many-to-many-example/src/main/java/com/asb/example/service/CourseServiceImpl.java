package com.asb.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asb.example.dto.CourseDto;
import com.asb.example.model.Course;
import com.asb.example.model.Student;
import com.asb.example.repo.CourseRepository;
import com.asb.example.repo.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private StudentRepository studentRepository;

	@Resource
	private CourseRepository courseRepository;

	@Transactional
	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		ModelMapper modelMapper=new ModelMapper();
		//Course course = new Course();
		//mapDtoToEntity(courseDto, course);
		Course savedCourse=modelMapper.map(courseDto,Course.class);
		courseRepository.save(savedCourse);
		return modelMapper.map(savedCourse,CourseDto.class);
			//mapEntityToDto(savedCourse);
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<CourseDto> courseDtos = new ArrayList<>();
		List<Course> courses = courseRepository.findAll();
		courses.stream().forEach(course -> {
			CourseDto courseDto =modelMapper.map(course,CourseDto.class); 
				//mapEntityToDto(course);
			courseDtos.add(courseDto);
		});
		return courseDtos;
	}

	@Transactional
	@Override
	public CourseDto updateCourse(Integer id, CourseDto courseDto) {
		Course crs = courseRepository.getOne(id);
		crs.getStudents().clear();
		mapDtoToEntity(courseDto, crs);
		Course course = courseRepository.save(crs);
		return mapEntityToDto(course);
	}

	@Transactional
	@Override
	public String deleteCourse(Integer id) {
		Optional<Course> course = courseRepository.findById(id);
		// Remove the related students from course entity.
		if(course.isPresent()) {
			course.get().removeStudents();
			courseRepository.deleteById(course.get().getId());
			return "Course with id: " + id + " deleted successfully!";
		}
		return null;
	}

// 	private void mapDtoToEntity(CourseDto courseDto, Course course) {
// 		course.setName(courseDto.getName());
// 		if (null == course.getStudents()) {
// 			course.setStudents(new HashSet<>());
// 		}
// 		courseDto.getStudents().stream().forEach(studentName -> {
// 			Student student = studentRepository.findByName(studentName);
// 			if (null == student) {
// 				student = new Student();
// 				student.setCourses(nfew HashSet<>());
// 			}
// 			student.setName(studentName);
// 			student.addCourse(course);
// 		});
// 	}

// 	private CourseDto mapEntityToDto(Course course) {
// 		CourseDto responseDto = new CourseDto();
// 		responseDto.setName(course.getName());
// 		responseDto.setId(course.getId());
// 		responseDto.setStudents(course.getStudents().stream().map(Student::getName).collect(Collectors.toSet()));
// 		return responseDto;
// 	}
}
