package com.mvc.diary.service;
import com.mvc.diary.models.Person;

public interface PersonService {
	
	Person findById(String id);
	Person findByEmail (String email);
	void insertPerson(Person person);
	void deletePerson (String id);
	void updatePerson (Person person);
	boolean isDuplicate (Person person);

}
