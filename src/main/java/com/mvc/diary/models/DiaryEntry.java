package com.mvc.diary.models;

import org.bson.types.ObjectId;
import java.util.Date;

public class DiaryEntry {
	private ObjectId _id;
	private Date entrydate;
	private boolean breakfast;
	private boolean lunch;
	private boolean snack;
	private boolean dinner;
	
	public DiaryEntry()  {}	
	
	public ObjectId getId() {return _id;}
	public void setId(final ObjectId  id) {this._id = id;}
	
	public Date getEntrydate() {return entrydate;}
	public void setEntrydate(final Date entrydate) {this.entrydate =entrydate;}
	
	public boolean getBreakfast() {return this.breakfast;}
	public void setBreakfast(boolean breakfast) {this.breakfast = breakfast;}
	
	public boolean getLunch() {return this.lunch;}
	public void setLunch (final boolean lunch) {this.lunch = lunch;}
	
	public boolean getSnack() {return this.snack;}
	public void setSnack (final boolean snack) {this.snack = snack;}
	
	public boolean getDinner() {return this.dinner;}
	public void setDinner (final boolean dinner) {this.dinner = dinner;}
	
	public void printValues() {
		System.out.println("Id = " + this._id);
		System.out.println("EntryDate = " + this.entrydate);
		System.out.println("Breakfast = " + this.breakfast);
		System.out.println("Lunch = " + this.lunch);
		System.out.println("Snack = " + this.snack);
		System.out.println("Dinner = " + this.dinner);
	}
}
