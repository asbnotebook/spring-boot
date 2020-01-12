package com.asb.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asb.example.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}