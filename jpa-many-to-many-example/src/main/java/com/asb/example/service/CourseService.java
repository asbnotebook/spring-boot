package com.asb.example.service;

import java.util.List;

import com.asb.example.dto.CourseDto;

public interface CourseService {

	public CourseDto updateCourse(Integer id, CourseDto course);

	public String deleteCourse(Integer id);

	public CourseDto addCourse(CourseDto courseDto);

	public List<CourseDto> getAllCourses();

}
