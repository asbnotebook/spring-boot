package com.asbnotebook.controller;

import com.asbnotebook.domain.Student;
import com.asbnotebook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") String id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        return studentService.deleteStudent(id);
    }
}