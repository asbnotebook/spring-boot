package com.asbnotebook.service;

import com.asbnotebook.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StudentService {

    Mono<Student> createStudent(Student student);

    Mono<Student> updateStudent(String id, Student student);

    Mono<String> deleteStudent(String id);

    Flux<Student> getStudentByFirstName(String firstName);

    Flux<Student> getAllStudents();
}
