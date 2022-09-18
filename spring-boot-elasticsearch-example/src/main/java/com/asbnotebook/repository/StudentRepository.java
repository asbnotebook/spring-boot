package com.asbnotebook.repository;

import com.asbnotebook.entity.Student;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveElasticsearchRepository<Student, String> {
    Flux<Student> findByFirstName(String firstName);
}
