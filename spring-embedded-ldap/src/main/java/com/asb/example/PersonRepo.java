package com.asb.example;

import java.util.List;

public interface PersonRepo {

	public List<Person> retrieve();
	public String create(Person p);
	public String update(Person p);
	public String remove(String userId);
}