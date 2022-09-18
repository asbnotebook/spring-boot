package com.asbnotebook.service;

import com.asbnotebook.entity.Student;
import com.asbnotebook.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Mono<Student> createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Mono<Student> updateStudent(String id, Student student) {
        return studentRepository.findById(id).flatMap(std -> {
                    log.info("std-{}", std);
                    std.setFirstName(student.getFirstName());
                    std.setLastName(student.getLastName());
                    std.setJoinDate(student.getJoinDate());
                    std.setSubjects(student.getSubjects());
                    std.setAge(student.getAge());
                    std.setAddress(student.getAddress());
                    return studentRepository.save(std);
                })
                .doOnError(e -> log.error(String.valueOf(e)));
    }

    @Override
    public Mono<String> deleteStudent(String id) {
        return studentRepository.deleteById(id)
                .thenReturn("Student deleted successfully!");
    }

    @Override
    public Flux<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Flux<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
