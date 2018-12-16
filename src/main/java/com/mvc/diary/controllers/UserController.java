package com.mvc.diary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.mvc.diary.models.User;
import com.mvc.diary.service.UserService;



@RestController

public class UserController {
	
	@Autowired
	private UserService userservice;
	
	public UserController() {
	}
	
	@RequestMapping (value ="/diary/get-user/{id}", 
			         produces = { "application/json" },  
			         method=RequestMethod.GET)
	
	public ResponseEntity<User> getUser(@PathVariable("id") String userid) {
		return new ResponseEntity<>(userservice.findById(userid),HttpStatus.OK);
	}
	
	@RequestMapping (value ="/diary/get-userbyname/{username}", 
	         produces = { "application/json" },  
	         method=RequestMethod.GET)

	public ResponseEntity<User>  getUserbyUsername(@PathVariable("username") String username) {
		User user = userservice.findByUserName(username);
		if (user!= null) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("UserId", user.getId().toString());
			return new ResponseEntity<>(user,headers,HttpStatus.OK);
		}
		else
		{
			user = new User();
			return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
		}
	}	
	

	@RequestMapping (value ="/diary/createUser", 
	         produces = { "application/json" },
	         consumes = {"application/json"},
	         method=RequestMethod.POST)

	public ResponseEntity<String> createUser(@RequestBody User user, UriComponentsBuilder builder) {
		 if ((user.getPwd() == null)|| (user.getUsername()== null))
		 {
			 HttpHeaders headers = new HttpHeaders();
			 headers.add("msg", "Error - Not all Mandatory Parameters are populated ");
			 return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);
		 }
		 else {
			 boolean isOK = userservice.insertUser(user);
			 user = userservice.findByUserName(user.getUsername());
			 HttpHeaders headers = new HttpHeaders();
			 user.printValues();
		     headers.setLocation(builder.path("/dairy/get-user/{id}").buildAndExpand(user.getId()).toUri());
		     if (isOK)
		    	  return new ResponseEntity<>(headers,HttpStatus.CREATED);
		     else {
		    	  headers.add("msg", "Error - Duplicate Username ");
		    	  return new ResponseEntity<>(headers,HttpStatus.CONFLICT);
		     }
		 }
	}		
	


}