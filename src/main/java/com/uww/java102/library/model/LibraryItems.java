package com.uww.java102.library.model;

import com.uww.java102.library.model.LibraryItems;

public abstract class LibraryItems {
	
	// instance variables
	private int barcode;
	private int checkoutTime;
	private int copiesAvailable;
	private String length;
	private String location;
	private String title;
	private String objectType;
	
	// constructors
	public LibraryItems(int checkoutTime, int copiesAvailable, String length, String location, String title, String objectType) {
		
		this.checkoutTime = checkoutTime;
		this.copiesAvailable = copiesAvailable;
		this.length = length;
		this.location = location;
		this.title = title;
		this.objectType = objectType;
		
	}
	
	public LibraryItems(int barcode, int checkoutTime, int copiesAvailable, String length, String location, String title) {
		
		this.barcode = barcode;
		this.checkoutTime = checkoutTime;
		this.copiesAvailable = copiesAvailable;
		this.length = length;
		this.location = location;
		this.title = title;
		
	}
	
	
	public LibraryItems(int barcode, String title) {
		this.barcode = barcode;
		this.title = title;
	}
	
	public LibraryItems(String title, int checkoutTime) {
		this.title = title;
		this.checkoutTime = checkoutTime;
	}
	
	
	// getter methods 
	public int getBarcode() {
		
		return barcode;
		
	}
	
	public int getCheckoutTime() {
		
		return checkoutTime;
		
	}
	
	public int getCopiesAvailable() {
		
		return copiesAvailable;
		
	}
	
	public String getLength() {
		
		return length;
		
	}
	
	public String getLocation() {
		
		return location;
		
	}
	
	public String getTitle() {
		
		return title;
		
	}
	
	public String getObjectType() {
		return objectType;
	}
	
	// abstract method to be implemented in subclasses 
	public abstract String toString();
	
	// prints out detailed information on item 
	public String Summary() {
		
		// COMPLETE THIS METHOD
		return String.format("%s: %s\n\t%s: %d\n\t%s: %d\n\t%s: %s\n\t%s: %s\n\t%s: %d", this.getClass().getSimpleName(),
				getTitle(), "barcode", getBarcode(), "copies available", getCopiesAvailable(), 
				"location", getLocation(), "length", getLength(), "checkout time", getCheckoutTime());
		
	}
//	private int barcode;
//	private int checkoutTime;
//	private int copiesAvailable;
//	private String length;
//	private String location;
//	private String title;
	
}
