package com.asb.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.asb.example.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}