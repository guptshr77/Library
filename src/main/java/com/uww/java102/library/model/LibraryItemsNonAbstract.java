package com.uww.java102.library.model;

public class LibraryItemsNonAbstract {


	private String title;
	private int checkoutTime;
	private int copiesavailable;

	public LibraryItemsNonAbstract(String title, int checkoutTime, int copiesavailable) {
		this.title = title;
		this.checkoutTime = checkoutTime;
		this.copiesavailable = copiesavailable;
	}
	
	//getter methods
	public String getTitle() {
		return title;
	}

	public int getCheckoutTime() {
		return checkoutTime;
	}
	
	public int getCopiesAvailable() {
		return copiesavailable;
	}
}
