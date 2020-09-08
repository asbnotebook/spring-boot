package com.asbnotebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asbnotebook.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
