package com.asbnotebook.repository;

import com.asbnotebook.domain.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface StudentRepository extends CassandraRepository<Student, UUID> {
}
