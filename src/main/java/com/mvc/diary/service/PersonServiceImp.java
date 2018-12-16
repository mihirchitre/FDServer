/**
 * 
 */
package com.mvc.diary.service;

import org.springframework.stereotype.Service;

import com.mvc.diary.models.Person;

import com.mvc.diary.utils.Connection;

/**
 * @author mchi0002
 *
 */
@Service("personservice")
public class PersonServiceImp implements PersonService {

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.PersonService#findById(java.lang.String)
	 */
	@Override
	public Person findById(String id) {
		// TODO Auto-generated method stub
		
		Connection col = new Connection();
		Person person = (Person) col.search("person", id, Boolean.FALSE);
		person.printValues();
		return person;
	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.PersonService#findByUserName(java.lang.String)
	 */
	@Override
	public Person findByEmail(String email) {
		// TODO Auto-generated method stub
		Connection col = new Connection();
		
		Person person = (Person) col.search("person", email, Boolean.TRUE);
		person.printValues();
		return person;

	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.PersonService#insertPerson(com.mvc.diary.models.Person)
	 */
	@Override
	public void insertPerson(Person person) {
		// TODO Auto-generated method stub
		person.printValues();
		Connection col = new Connection();
		col.insert("person", person);
	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.PersonService#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.PersonService#updatePerson(com.mvc.diary.models.Person)
	 */
	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.PersonService#isDuplicate(com.mvc.diary.models.Person)
	 */
	@Override
	public boolean isDuplicate(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

}
