package com.mvc.diary.models;

import org.bson.types.ObjectId;

public class Person {
	
	private ObjectId _id;
	private String email;
	private String firstname;
	private String lastname;
	private String phone;
	
	public Person () {}
	
	public ObjectId getId() {
		return _id;
	}
	public void setId(final ObjectId  id) {this._id = id;}
	
	
	public void setEmail (final String email) {this.email = email;}
	public String getEmail() {
		return email;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	public void setFirstname (final String firstname) {this.firstname = firstname;}
	
	public String getLastname() {
		return this.lastname;
	}
	public void setLastname (final String lastname) {this.lastname = lastname;}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone (final String phone) {this.phone = phone;}
	
	public String getName() {
		return firstname + " " + lastname;
	}
	
	public boolean isMandatoryFieldsPopulated() {
		if ((this.email == null) || (this.firstname == null) || (this.lastname ==null)) {
			return false;
		}
		else if (this.email.isEmpty() || this.firstname.isEmpty() || this.lastname.isEmpty()){
			return false;
		}
		return true;
	}

	public void printValues() {
		System.out.println("Id = " + this._id);
		System.out.println("Name = " + this.getName());
		System.out.println("Email = " + this.getEmail());
		System.out.println("Phone = " + this.getPhone());
	}
}
