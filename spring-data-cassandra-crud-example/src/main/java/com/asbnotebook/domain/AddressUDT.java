package com.asbnotebook.domain;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("address")
public class AddressUDT {

    private String street;
    @Column("door_number")
    private Integer doorNo;
    @Column("pin_code")
    private Integer pinCode;
}
