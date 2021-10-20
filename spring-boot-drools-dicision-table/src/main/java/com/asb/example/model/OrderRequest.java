package com.asb.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

	private String customerNumber;
	private Integer age;
	private Integer amount;
	private CustomerType customerType;
}