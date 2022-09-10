package com.asbnotebook.example.controller;

import com.asbnotebook.example.model.Student;
import com.asbnotebook.example.model.Students;
import com.asbnotebook.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-students")
    public ResponseEntity<Students> getAllStudents(){
        var list = studentService.getStudents();
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/get-student")
    public ResponseEntity<Student> getAllStudent(@RequestParam String name){
        return  new ResponseEntity<>(studentService.getStudent(name), HttpStatus.OK);
    }
}
