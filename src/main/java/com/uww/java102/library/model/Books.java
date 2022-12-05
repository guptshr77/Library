package com.uww.java102.library.model;

import com.uww.java102.library.model.Books;

public class Books extends LibraryItems{
	
	// instance variables 
	private String genre;
	private String author;
	private String summary;
	private String ageRange;
	private String paper;
	
	// constructors 
	public Books(int checkoutTime, int copiesAvailable, String length, String location, String title, String objectType,
			String genre, String author, String summary, String ageRange, String paper) {
		
		super(checkoutTime, copiesAvailable, length, location, title, objectType);
		
		this.genre = genre;
		this.author = author;
		this.summary = summary;
		this.ageRange = ageRange;
		this.paper = paper;
		
	}
	
	public Books(int barcode, int checkoutTime, int copiesAvailable, String length, String location, String title,
			String genre, String author, String summary, String ageRange) {
		
		super(barcode, checkoutTime, copiesAvailable, length, location, title);
		
		this.genre = genre;
		this.author = author;
		this.summary = summary;
		this.ageRange = ageRange;
		
	}
	
	public Books(int barcode, String title, String author) {
	
		super(barcode, title);
	
		this.author = author;
	}
	
	// getter methods 
	public String getGenre() {
		
		return genre;
		
	}
	
	public String getAuthor() {
		
		return author;
		
	}
	
	public String getSummary() {
		
		return summary;
		
	}
	
	public String getAgeRange() {
		
		return ageRange;
		
	}
	
	public String getPaper() {
		return paper;
	}
	
	// returns LibraryItems basic information 
	@Override
	public String toString() {
		
		return String.format("%s : %s \n\t%s: %d \n\t%s: %s \n", this.getClass().getSimpleName(), 
				super.getTitle(), "barcode", super.getBarcode(), "author", getAuthor()); 
		
	}
	
	// prints out detailed information on item 
	@Override
	public String Summary() {
			
		return String.format("%s \n\t%s: %s \n\t%s: %s \n\t%s: %s \n\t%s: %s\n", super.Summary(), 
				"genre", getGenre(), "author", getAuthor(), "summary", getSummary(), "age range", getAgeRange());
			
	}
	
}
