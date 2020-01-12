package com.asb.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@ApiModel(description="Student Model class",value="Student Model")
public class Student {

	@ApiModelProperty(dataType="Long", required=true, name="Student Id", value="1")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studntId;
	
	@ApiModelProperty(dataType="String", required=true, name="Student Name", value="Arun")
	private String name;
	
	@ApiModelProperty(dataType="String", required=true, name="Grade", value="XI")
	private String grade;
}
