package com.asbnotebook.domain;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table("students")
public class Student {

    @PrimaryKey
    private UUID id = Uuids.timeBased();

    @Column("student_name")
    private String name;

    private Integer grade;

    @Column("address")
    private AddressUDT address;

    @Column("subjects")
    private List<SubjectUDT> subjects;
}
