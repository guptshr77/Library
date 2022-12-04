package com.uww.java102.library.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.uww.java102.library.model.Books;
import com.uww.java102.library.model.AudioBooks;
import com.uww.java102.library.model.Digital;
import com.uww.java102.library.model.Research;


@Component
public class SearchDAO {
	//wired to jdbc template that connects to database and makes object and returns it
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	//Short Book Search
		//search book
		public List<Books> searchBook(String input){
			String query = "SELECT l.barcode, title, author FROM libraryitems l INNER JOIN book b ON l.barcode = b.barcode WHERE booktype = 'paper' AND title LIKE '%" + input + "%'";
			
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new Books(
							rs.getInt("barcode"),
							rs.getString("title"),
							rs.getString("author")));
		}
	
		//search audiobook
		public List<AudioBooks> searchAudioBook(String input){
			String query = "SELECT l.barcode, title, author, speaker FROM libraryitems l INNER JOIN book b ON l.barcode = b.barcode INNER JOIN audiobook a ON b.barcode = a.barcode WHERE title LIKE '%" + input + "%'";
			
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new AudioBooks(
							rs.getInt("barcode"),
							rs.getString("title"),
							rs.getString("author"),
							rs.getString("speaker")));
		}
		//search digital
		public List<Digital> searchDigital(String input) {
			String query = "SELECT l.barcode, title, creator, digitaltype FROM libraryitems l INNER JOIN digital d ON l.barcode = d.barcode WHERE title LIKE '%" + input +"%'";
			
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new Digital(
							rs.getInt("barcode"),
							rs.getString("title"),
							rs.getString("creator"),
							rs.getString("digitaltype")));
		}
		
		//search research 
		public List<Research> searchResearch(String input) {
			String query = "SELECT l.barcode, title, publisher, topic, researchtype FROM libraryitems l INNER JOIN research r ON l.barcode = r.barcode WHERE title LIKE '%" + input + "%'";
			
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new Research(
							rs.getInt("barcode"),
							rs.getString("title"),
							rs.getString("publisher"),
							rs.getString("topic"),
							rs.getString("researchtype")));
		}
		
	//search in depth 
		//search book
		public List<Books> searchBookMore(int barcode) {
			String query = "SELECT l.barcode, checkouttime, copiesavailable, itemlength, ilocation, title, genre, author, summary, agerange FROM libraryitems l INNER JOIN book b ON l.barcode = b.barcode WHERE l.barcode = " + barcode +" AND b.barcode = " + barcode;
		
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new Books(
							rs.getInt("barcode"),
							rs.getInt("checkouttime"),
							rs.getInt("copiesavailable"),
							rs.getString("itemlength"),
							rs.getString("ilocation"),
							rs.getString("title"),
							rs.getString("genre"),
							rs.getString("author"),
							rs.getString("summary"),
							rs.getString("agerange")));
		}
		//search audiobook
		public List<AudioBooks> searchAudioBookMore(int barcode){
			String query = "SELECT l.barcode, checkouttime, copiesavailable, itemlength, ilocation, title, genre, author, summary, agerange, speaker FROM libraryitems l INNER JOIN book b ON l.barcode = b.barcode INNER JOIN audiobook a ON b.barcode = a.barcode WHERE l.barcode = " + barcode + " AND a.barcode = " + barcode;
		
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new AudioBooks(
							rs.getInt("barcode"),
							rs.getInt("checkouttime"),
							rs.getInt("copiesavailable"),
							rs.getString("itemlength"),
							rs.getString("ilocation"),
							rs.getString("title"),
							rs.getString("genre"),
							rs.getString("author"),
							rs.getString("summary"),
							rs.getString("agerange"),
							rs.getString("speaker")));
		}
		
		//search digital
		public List<Digital> searchDigitalMore(int barcode){
			String query = "SELECT l.barcode, checkouttime, copiesavailable, itemlength, ilocation, title, genre, creator, digitaltype, description FROM libraryitems l INNER JOIN digital d ON l.barcode = d.barcode WHERE l.barcode = " + barcode + " AND d.barcode = " + barcode;
		
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new Digital(
							rs.getInt("barcode"),
							rs.getInt("checkouttime"),
							rs.getInt("copiesavailable"),
							rs.getString("itemlength"),
							rs.getString("ilocation"),
							rs.getString("title"),
							rs.getString("genre"),
							rs.getString("creator"),
							rs.getString("digitaltype"),
							rs.getString("description")));
		}
		
		
		
		//search research 		
		public List<Research> searchResearchMore(int barcode){
			String query = "SELECT l.barcode, checkouttime, copiesavailable, itemlength, ilocation, title, genre, creator, digitaltype, description FROM libraryitems l INNER JOIN digital d ON l.barcode = d.barcode WHERE l.barcode = " + barcode + " AND d.barcode = " + barcode;
		
			return jdbcTemplate.query(query, 
					(rs, rowNum) ->
					new Research(
							rs.getInt("barcode"),
							rs.getInt("checkouttime"),
							rs.getInt("copiesavailable"),
							rs.getString("itemlength"),
							rs.getString("ilocation"),
							rs.getString("title"),
							rs.getInt("publishdate"),
							rs.getString("topic"),
							rs.getString("publisher"),
							rs.getString("researchtype")));
		}
		
		
}
