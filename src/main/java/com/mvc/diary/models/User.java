package com.mvc.diary.models;


import org.bson.types.ObjectId;

public class User {
	private ObjectId _id;
	private String username;
	private String pwd;
	
	public User() {}
	
	public ObjectId getId() {return this._id;}
	public void setId(final ObjectId id) { this._id = id;}

	public String getUsername() {return this.username;}
	public void setUsername (final String username) {this.username = username;}
	public String getPwd() {return this.pwd;}
	public void setPwd (final String pwd) { this.pwd = pwd;}
	
	public void printValues() {
		System.out.println("Id = " + this.getId());
		System.out.println("username = " + this.getUsername());
		System.out.println("pwd = " + this.getPwd());
	}
}
