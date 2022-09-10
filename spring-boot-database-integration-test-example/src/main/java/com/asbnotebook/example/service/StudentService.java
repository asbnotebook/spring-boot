package com.asbnotebook.example.service;

import com.asbnotebook.example.model.Student;
import com.asbnotebook.example.model.Students;
import com.asbnotebook.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Students getStudents(){
        return Students.builder().students(studentRepository.findAll()).build();
    }

    public Student getStudent(String name){
        return studentRepository.findByName(name).orElse(null);
    }
}
