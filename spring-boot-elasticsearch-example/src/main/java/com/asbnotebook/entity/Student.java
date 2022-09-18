package com.asbnotebook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "student-details")
@Data
public class Student {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String firstName;

    private String lastName;

    private int age;

    @Field(type = FieldType.Date, format = DateFormat.date)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    private Address address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Subject> subjects;
}
