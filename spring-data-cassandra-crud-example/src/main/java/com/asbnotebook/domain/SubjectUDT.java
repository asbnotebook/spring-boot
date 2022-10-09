package com.asbnotebook.domain;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("subject")
public class SubjectUDT {

    private String name;
}