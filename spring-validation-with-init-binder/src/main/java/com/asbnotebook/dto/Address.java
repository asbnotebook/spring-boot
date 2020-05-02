package com.asbnotebook.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	private String street;
	private Integer doorNo;
	private String additionalInfo;
}
