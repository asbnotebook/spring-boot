package com.asbnotebook.example.model;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Students {
    List<Student> students;
}
