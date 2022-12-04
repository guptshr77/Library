package com.uww.java102.library.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.uww.java102.library.model.AudioBooks;
import com.uww.java102.library.model.Books;
import com.uww.java102.library.model.Digital;
import com.uww.java102.library.model.Research;

@Component
public class AddRemoveDAO {

	@Autowired 
	private JdbcTemplate jdbcTemplate;
	//remove items
		//remove book 
			// DELETE FROM book WHERE barcode = ?;
			//DELETE FROM libraryitems WHERE barcode = ?;
		public String removeBook(int barcode) {
			String stmt = "DELETE FROM book WHERE barcode = ?";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode);
						
						return ps.execute();
				}
			});
			removeLibraryItem(barcode);
			
			return "Book deleted!";
		}

		//remove audiobook
			//DELETE FROM audiobook WHERE barcode = ?;
			//DELETE FROM book WHERE barcode = ?;
			//DELETE FROM libraryitems WHERE barcode = ?;
		public String removeAudioBook(int barcode) {
			String stmt = "DELETE FROM audiobook WHERE barcode = ?";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode);
						
						return ps.execute();
				}
			});
			
			stmt = "DELETE FROM book WHERE barcode = ?";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode);
						
						return ps.execute();
				}
			});
			removeLibraryItem(barcode);
			
			return "Audiobook deleted!";
		}
		//remove research
			//DELETE FROM research WHERE barcode = ?;
			//DELETE FROM libraryitems WHERE barcode = ?;
		public String removeResearch(int barcode) {
			String stmt = "DELETE FROM research WHERE barcode = ?";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode);
						
						return ps.execute();
				}
			});
			removeLibraryItem(barcode);
			
			return "Research item deleted!";
		}
		
		//remove digital
			//DELETE FROM digital WHERE barcode = ?;
			//DELETE FROM libraryitems WHERE barcode = ?;
		public String removeDigital(int barcode) {
			String stmt = "DELETE FROM digital WHERE barcode = ?";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode);
						
						return ps.execute();
				}
			});
			removeLibraryItem(barcode);
			
			return "Digital item deleted!";
		}
		
		//delete libraryitem common for all of the above
		private void removeLibraryItem(int barcode) {
			String stmt = "DELETE FROM libraryitems WHERE barcode = ?";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode);
						
						return ps.execute();
				}
			});
		}
		
	//add items
		//add book
			//INSERT INTO libraryitems(copiesavailable, itemlength, ilocation, title) VALUES (?,?,?,?);
			//INSERT INTO book (barcode, genre, author, summary, agerange)VALUES (?,?,?,?,?);
		public String addBook(Books book) {
			addLibraryItem(book.getCopiesAvailable(), book.getLength(), book.getLocation(), book.getTitle());
			
			String stmt = "INSERT INTO book (barcode, genre, author, summary, agerange)VALUES (?,?,?,?,?)";
			
			List<Integer> barcode = getBarcode( book.getTitle());
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode.get(0));
						ps.setString(2, book.getGenre());
						ps.setString(3, book.getAuthor());
						ps.setString(4, book.getSummary());
						ps.setString(5, book.getAgeRange());
						
						return ps.execute();
				}
			});
			
			return "Book added!";
		}
		
		//add audiobook
			//INSERT INTO libraryitems(copiesavailable, itemlength, ilocation, title) VALUES (?,?,?,?);
			//INSERT INTO book (barcode, genre, author, summary, agerange)VALUES (?,?,?,?,?);
			//INSERT INTO audiobook (barcode, speaker) VALUES (?,?);
		
		public String addAudioBook(AudioBooks ab) {
			addLibraryItem(ab.getCopiesAvailable(), ab.getLength(), ab.getLocation(), ab.getTitle());
			
			String stmt = "INSERT INTO book (barcode, genre, author, summary, agerange)VALUES (?,?,?,?,?);";
			
			List<Integer> barcode = getBarcode(ab.getTitle());
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode.get(0));
						ps.setString(2, ab.getGenre());
						ps.setString(3, ab.getAuthor());
						ps.setString(4, ab.getSummary());
						ps.setString(5, ab.getAgeRange());
						
						return ps.execute();
				}
			});
			
			stmt = "INSERT INTO audiobook (barcode, speaker) VALUES (?,?);";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode.get(0));
						ps.setString(2, ab.getSpeaker());
						
						return ps.execute();
				}
			});
			
			return "Audiobook added!";
		}
		
		//add research
			//INSERT INTO libraryitems(copiesavailable, itemlength, ilocation, title) VALUES (?,?,?,?);
			//INSERT INTO research (barcode, publishdate, topic, publisher, researchtype)VALUES (?,?,?,?,?);
		public String addResearch(Research research) {
			addLibraryItem(research.getCopiesAvailable(), research.getLength(), research.getLocation(), research.getTitle());
			
			String stmt = "INSERT INTO research (barcode, publishdate, topic, publisher, researchtype)VALUES (?,?,?,?,?)";
			
			List<Integer> barcode = getBarcode(research.getTitle());
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode.get(0));
						ps.setInt(2, research.getPublishedDate());
						ps.setString(3, research.getTopic());
						ps.setString(4, research.getPublisher());
						ps.setString(5, research.getType());
						
						return ps.execute();
				}
			});
			
			return "Research item added!";
		}
		
		//add digital
			//INSERT INTO libraryitems(copiesavailable, itemlength, ilocation, title) VALUES (?,?,?,?);
			//INSERT INTO digital(barcode, genre, creator, digitaltype,description) VALUES (?,?,?,?,?);
		
		public String addDigital(Digital digital) {
			addLibraryItem(digital.getCopiesAvailable(), digital.getLength(), digital.getLocation(), digital.getTitle());
			
			List<Integer> barcode = getBarcode(digital.getTitle());
			
			String stmt = "INSERT INTO digital(barcode, genre, creator, digitaltype,description) VALUES (?,?,?,?,?)";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, barcode.get(0));
						ps.setString(2, digital.getGenre());
						ps.setString(3, digital.getCreator());
						ps.setString(4, digital.getType());
						ps.setString(5, digital.getDescription());
						
						return ps.execute();
				}
			});
			
			return "Digital item added!";
		}
		
		private void addLibraryItem(int copiesavailable, String itemlength, String ilocation, String title) {
			String stmt = "INSERT INTO libraryitems(copiesavailable, itemlength, ilocation, title) VALUES (?,?,?,?)";
			
			jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException{
						ps.setInt(1, copiesavailable);
						ps.setString(2, itemlength);
						ps.setString(3, ilocation);
						ps.setString(4, title);
						
						return ps.execute();
				}
			});
			
			//ASK HOW TO GET PRIMARY KEY OF AN OBJECT YOU JUST CREATED
		}
		
		@SuppressWarnings("deprecation")
		private List<Integer> getBarcode(String title) {
			String query = "SELECT barcode FROM libraryitems WHERE title = '" + title + "'";
			
			return jdbcTemplate.query(query, 
					(rs, rowNum) -> 
						new Integer(
								rs.getInt("barcode")));
			
		}
}

