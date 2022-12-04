package com.uww.java102.library.model;

import com.uww.java102.library.model.Digital;

public class Digital extends LibraryItems{
	
	// instance variables
	private String genre;
	private String creator;
	private String description;
	private String type;
	
	// constructors
	public Digital(int checkoutTime, int copiesAvailable, String length, String location, String title, String objectType,
			String genre, String creator, String description, String type) {
		
		super(checkoutTime, copiesAvailable, length, location, title, objectType);
		
		this.genre = genre;
		this.creator = creator;
		this.description = description;
		this.type = type;
		
	}
	
	public Digital(int barcode, int checkoutTime, int copiesAvailable, String length, String location, String title,
			String genre, String creator, String description, String type) {
		
		super(barcode, checkoutTime, copiesAvailable, length, location, title);
		
		this.genre = genre;
		this.creator = creator;
		this.description = description;
		this.type = type;
		
	}
	
	public Digital(int barcode, String title, String creator, String type) {
		
		super(barcode, title);
		
		this.creator = creator;
		this.type = type;
	}

	// getter methods
	public String getGenre() {
		
		return genre;
		
	}
	
	public String getCreator() {
		
		return creator;
		
	}	
	
	public String getDescription() {
		
		return description;
		
	}
	
	public String getType() {
		
		return type;
		
	}
	
	// returns LibraryItems basic information 
	@Override
	public String toString() {
		
		return String.format("%s : %s \n\t%s: %d \n\t%s: %s \n\t%s: %s \n", this.getClass().getSimpleName(), 
				super.getTitle(), "barcode", super.getBarcode(), "creator", getCreator(), "type", getType()); 
		
	}
	
	// prints out detailed information on item 
	@Override
	public String Summary() {
			
		return String.format("%s \n\t%s: %s \n\t%s: %s \n\t%s: %s \n\t%s: %s\n\t%s: %s \n", super.Summary(), 
				"genre", getGenre(), "creator", getCreator(), "description", getDescription(), "type", getType(), "genre", getGenre());
			
	}
	
}
