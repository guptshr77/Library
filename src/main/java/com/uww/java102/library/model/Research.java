package com.uww.java102.library.model;

import com.uww.java102.library.model.Research;

public class Research extends LibraryItems {
	
	// instance variables 
	private int publishedDate;
	private String topic;
	private String publisher;
	private String type;
	
	// constructors 
	public Research(int checkoutTime, int copiesAvailable, String length, String location, String title, String objectType,
			int publishedDate, String topic, String publisher, String type) {
		
		super(checkoutTime, copiesAvailable, length, location, title, objectType);
		
		this.publishedDate = publishedDate;
		this.topic = topic;
		this.publisher = publisher;
		this.type = type;
		
	}
	
	public Research(int barcode, int checkoutTime, int copiesAvailable, String length, String location, String title,
			int publishedDate, String topic, String publisher, String type) {
		
		super(barcode, checkoutTime, copiesAvailable, length, location, title);
		
		this.publishedDate = publishedDate;
		this.topic = topic;
		this.publisher = publisher;
		this.type = type;
		
	}
	
	public Research(int barcode, String title, String publisher, String topic, String type) {
		
		super(barcode, title);
		
		this.publisher = publisher;
		this.topic = topic;
		this.type = type;
	}

	// getter methods
	public int getPublishedDate() {
		
		return publishedDate;
		
	}
	
	public String getTopic() {
		
		return topic;
		
	}
	
	public String getPublisher() {
		
		return publisher;
		
	}
	
	public String getType() {
		
		return type;
		
	}
	
	// returns LibraryItems basic information 
	@Override
	public String toString() {
		
		return String.format("%s : %s \n\t%s: %d \n\t%s: %s \n\t%s: %s \n\t%s: %s \n", this.getClass().getSimpleName(), 
				super.getTitle(), "barcode", super.getBarcode(), "publisher", getPublisher(), "topic", getTopic(), "type", getType()); 
		
	}
	
	// prints out detailed information on item 
	@Override
	public String Summary() {
			
		return String.format("%s \n\t%s: %d \n\t%s: %s \n\t%s: %s \n\t%s: %s \n", super.Summary(), 
				"date published", getPublishedDate(), "topic", getTopic(), "publisher", getPublisher(), "type", getType());
			
	}
	
}
