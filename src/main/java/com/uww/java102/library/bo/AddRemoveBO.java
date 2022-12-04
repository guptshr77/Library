package com.uww.java102.library.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uww.java102.library.dal.AddRemoveDAO;
import com.uww.java102.library.model.AudioBooks;
import com.uww.java102.library.model.Books;
import com.uww.java102.library.model.Digital;
import com.uww.java102.library.model.Research;

@Component 
public class AddRemoveBO {
	@Autowired
	private AddRemoveDAO ard;
	
	//remove book 
	public String removeBookBO(int barcode) {
		return ard.removeBook(barcode);
	}
	//remove audiobook 
	public String removeAudioBookBO(int barcode) {
		return ard.removeAudioBook(barcode);
	}	
	//remove research
	public String removeResearchBO(int barcode) {
		return ard.removeResearch(barcode);
	}
	//remove digital
	public String removeDigitalBO(int barcode) {
		return ard.removeDigital(barcode);
	}
	//find out what type of object this is
	public String getType(int barcode) {
		List<String> type = ard.getType(barcode);
		
		return type.get(0);
	}
	
	
	//add book
	public String addBookBO(Books book) {
		return ard.addBook(book);
	}	
	//add audiobook
	public String addAudioBookBO(AudioBooks audiobook) {
		return ard.addAudioBook(audiobook);
	}	
	//add research
	public String addResearchBO(Research research) {
		return ard.addResearch(research);
	}
	//add digital 
	public String addDigitalBO(Digital digital) {
		return ard.addDigital(digital);
	}

}
