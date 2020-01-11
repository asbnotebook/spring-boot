package com.asb.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.asb.example.dto.Grade;
import com.asb.example.dto.School;
import com.asb.example.dto.Student;

@Component
public class JsonUtil {

	public School getSchoolDetails() {
		
		School school = new School();
		school.setName("My School");
		
		List<Student> students = new ArrayList<>();
		Student student1 = new Student();
		student1.setFirstName("Arun");
		student1.setLastName("SB");

		Grade grade1 = new Grade();
		grade1.setName("XI");
		student1.setGrade(grade1);
		
		Student student2 = new Student();
		student2.setFirstName("John");
		student2.setLastName("Taylor");

		Grade grade2 = new Grade();
		grade2.setName("X");
		student2.setGrade(grade2);
		
		Student student3 = new Student();
		student3.setFirstName("Malcom");
		student3.setLastName("Jr");

		Grade grade3 = new Grade();
		grade3.setName("VII");
		student3.setGrade(grade3);
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		school.setStudents(students);
		
		return school;
	}
}