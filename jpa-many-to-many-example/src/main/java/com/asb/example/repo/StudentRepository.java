package com.asb.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asb.example.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}