package com.asbnotebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.asbnotebook.entity.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

}