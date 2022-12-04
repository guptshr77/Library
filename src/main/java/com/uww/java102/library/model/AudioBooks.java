package com.uww.java102.library.model;

import com.uww.java102.library.model.AudioBooks;

public class AudioBooks extends Books{
	
	// instance variables
	private String speaker;
	
	// constructors
	public AudioBooks(int checkoutTime, int copiesAvailable, String length, String location, String title,
			String genre, String author, String summary, String ageRange, String speaker, String booktype) {
		
		super(checkoutTime, copiesAvailable, length, location, title, genre, author, summary, ageRange, booktype);
		
		this.speaker = speaker;
		
	}
	
	public AudioBooks(int barcode, int checkoutTime, int copiesAvailable, String length, String location, String title,
			String genre, String author, String summary, String ageRange, String speaker) {
		
		super(barcode, checkoutTime, copiesAvailable, length, location, title, genre, author, summary, ageRange);
		
		this.speaker = speaker;
		
	}
	

	
	public AudioBooks(int barcode, String title, String author, String speaker) {
		
		super(barcode, title, author);
		
		this.speaker = speaker;
	}

	// getter method
	public String getSpeaker() {
		
		return speaker;
		
	}
	
	// returns LibraryItems basic information 
	@Override
	public String toString() {
		
		return String.format("%s \n\t%s: %s \n", super.toString(), 
				"speaker", getSpeaker()); 
		
	}
	
	// prints out detailed information on item 
	@Override
	public String Summary() {
			
		return String.format("%s \t%s: %s \n", super.Summary(), "speaker", getSpeaker());
			
	}
	
}
