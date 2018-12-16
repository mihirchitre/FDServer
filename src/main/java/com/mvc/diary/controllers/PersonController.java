package com.mvc.diary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import com.mvc.diary.service.PersonService;
import com.mvc.diary.models.Person;


@Controller
public class PersonController {


	
	@Autowired
	private PersonService personservice;
	
	public PersonController() {
	}
	
	
	@RequestMapping (value ="/diary/get-person/{id}", 
	         produces = { "application/json" },  
	         method=RequestMethod.GET)

	public ResponseEntity<Person> getPerson(@PathVariable("id") String id) {
	return new ResponseEntity<>(personservice.findById(id),HttpStatus.OK);
	}
	
	@RequestMapping (value ="/diary/get-personbyname/{email}", 
	    produces = { "application/json" },  
	    method=RequestMethod.GET)
	
	public ResponseEntity<Person>  getPersonbyemail(@PathVariable("email") String email) {
	return new ResponseEntity<>(personservice.findByEmail(email),HttpStatus.OK);
	}	
	
	
	@RequestMapping (value ="/diary/createPerson", 
	    produces = { "application/json" },
	    consumes = {"application/json"},
	    method=RequestMethod.POST)
	
	public ResponseEntity<String> createPerson(@RequestBody Person person, UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();
		if (person.isMandatoryFieldsPopulated()) {
			personservice.insertPerson(person);
			headers.setLocation(builder.path("/dairy/get-person/{id}").buildAndExpand(person.getId()).toUri());
			return new ResponseEntity<>(headers,HttpStatus.CREATED);
		}
		 headers.add("msg", "Error - Not all Mandatory Parameters are populated ");
		 return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);
	}	
	

}