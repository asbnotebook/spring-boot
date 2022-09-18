package com.asbnotebook.controller;

import com.asbnotebook.entity.Student;
import com.asbnotebook.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/students")
    public Mono<Student> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/students/{id}")
    public Mono<Student> updateStudent(@RequestBody Student student, @PathVariable("id") String id) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public Mono<String> deleteStudent(@PathVariable("id")  String id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/students/{first-name}")
    public Flux<Student> getStudentByFirstname(@PathVariable("first-name") String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("/students")
    public Flux<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @ExceptionHandler
    public void handle(Exception e){
        e.printStackTrace();
    }
}