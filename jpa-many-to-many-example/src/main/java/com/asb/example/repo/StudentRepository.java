package com.asb.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asb.example.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
