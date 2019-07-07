package com.asb.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
public class Address {

	@Id
	@Column(name="id")
	@SequenceGenerator(initialValue=1, name="address_seq", sequenceName="address_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
	private int id;
	
	@Column(name="doornumber")
	private String doorNumber;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
}
