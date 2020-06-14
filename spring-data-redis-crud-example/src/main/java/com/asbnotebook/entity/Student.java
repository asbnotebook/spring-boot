package com.asbnotebook.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;

@Data
@RedisHash(value = "student")
public class Student {

	@Id
	@Indexed
	private String id;
	private String name;
	private String grade;
}