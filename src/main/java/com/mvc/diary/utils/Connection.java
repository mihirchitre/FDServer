package com.mvc.diary.utils;

import com.mongodb.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mvc.diary.models.*;

import static com.mongodb.client.model.Filters.*;


import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class Connection  {
	private MongoClient mongo;
	private MongoDatabase db;
	
	//@Value ("{spring.data.mongodb.host}")
	//String dbhost;
	
	@Value ("{spring.data.mongodb.port}")
	int dbport;
	@Value ("{spring.data.mongodb.database}")
	String dbname;
	
	public Connection() {
		
	}
	
	public  MongoDatabase getConnection( ) {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		//System.out.println("dbhost  " + dbhost);
		System.out.println("dbname  " + dbname);
		
		this.mongo = new MongoClient("localhost", 27017 );
		try {
			this.db = mongo.getDatabase("diary");
			db = db.withCodecRegistry(pojoCodecRegistry);
		}
		catch (IllegalArgumentException err) {
			System.out.println("Database Diary Cannot be accessed \n");
			System.out.println(err.getStackTrace().toString());
			this.db = null;
		}
		return db;
	}
	
	public void closeConnection() {
		this.mongo.close();
	}
	
	
	public void insert(String objtype, Object obj) {
		getConnection();
		if (obj instanceof User) {
			MongoCollection<User> collection =  db.getCollection(objtype,User.class);
			if (collection != null) {
				collection.insertOne((User)obj);
				((User) obj).printValues();
			}
			else {System.out.println("MONGODB COLLECTION NOT FOUND");}
		}
		else if (obj instanceof Person) {
			MongoCollection<Person> collection =  db.getCollection(objtype,Person.class);
			if (collection != null) {
				collection.insertOne((Person)obj);
				((Person) obj).printValues();
			}
			else {System.out.println("MONGODB COLLECTION NOT FOUND");}
		}
		else {System.out.println("OBJECT NOT FOUND");}
		closeConnection();
	}
	
	public Object search (String objtype, String id, Boolean byparam) {
		Object obj = null;
		getConnection();
		if (objtype.equalsIgnoreCase("user")) {
			MongoCollection<User> collection =  db.getCollection(objtype,User.class);
			if (collection != null) {
				 if (byparam.booleanValue() ==false) {
					 obj = (User) collection.find(eq ("_id", new ObjectId(id)) ).first();
				 }
				 else {
					 try {
						 obj = (User) collection.find(eq ("username", id)).first();
					 }
					 catch (Exception err ) {
						obj = null;
					 }
				 }
			}
			else {System.out.println("MONGODB COLLECTION NOT FOUND");}
		}
		else if (objtype.equalsIgnoreCase("person")) {
			MongoCollection<Person> collection =  db.getCollection(objtype,Person.class);
			if (collection != null) {
				 if (byparam.booleanValue() ==false) {
					 obj = (Person) collection.find(eq ("_id", new ObjectId(id)) ).first();
				 }
				 else {
					 try {
						 obj = (Person) collection.find(eq ("email", id)).first();
					 }
					 catch (Exception err ) {
						obj = null; 
					}
				 }
			}
		}
		else {System.out.println("OBJECT NOT FOUND");}
		closeConnection();
		return obj;
	}

}
