package com.asbnotebook.controller;


import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class EmployeeDto {
    private Long id;
    private String name;
    private Integer salary;
}
