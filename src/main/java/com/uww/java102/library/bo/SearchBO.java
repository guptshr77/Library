package com.uww.java102.library.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uww.java102.library.dal.SearchDAO;
import com.uww.java102.library.model.AudioBooks;
import com.uww.java102.library.model.Books;
import com.uww.java102.library.model.Digital;
import com.uww.java102.library.model.Research;
@Component
public class SearchBO {
	@Autowired
	private SearchDAO sd;
	
	//search book
	public List<Books> searchBookBO(String input){
		return sd.searchBook(input);
	}
	//search audiobook 
	public List<AudioBooks> searchAudioBookBO(String input){
		return sd.searchAudioBook(input);
	}	
	//search digital 
	public List<Digital> searchDigitalBO(String input){
		return sd.searchDigital(input);
	}
	//search research 
	public List<Research> searchResearchBO(String input){
		return sd.searchResearch(input);
	}
	//search book more 
	public List<Books> searchBookMoreBO(int barcode){
		return sd.searchBookMore(barcode);
	}
	//search audiobook more 
	public List<AudioBooks> searchAudioBookMoreBO(int barcode){
		return sd.searchAudioBookMore(barcode);
	}	
	//search digital more 
	public List<Digital> searchDigitalMoreBO(int barcode){
		return sd.searchDigitalMore(barcode);
	}
	//search research more 
	public List<Research> searchResearchMoreBO(int barcode){
		return sd.searchResearchMore(barcode);
	}
	

}
