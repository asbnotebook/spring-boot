package com.asb.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
	
	private Integer id;
	private String empName;
	private Date date;
	private LocalDate joinDate;
	private LocalDateTime joinDateTime;
}
