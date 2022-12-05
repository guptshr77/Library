package com.uww.java102.library.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.uww.java102.library.model.LibraryItemsNonAbstract;

@Component
public class CheckoutReturnItemsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//Checkout Items
	public List<LibraryItemsNonAbstract> checkoutItem(int barcode) {
		String stmt = "UPDATE libraryitems SET copiesavailable = (SELECT copiesavailable FROM libraryitems WHERE barcode = " + barcode + ") - 1 WHERE barcode = " + barcode;
		
		jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps)
				throws SQLException, DataAccessException{
					
					return ps.execute();
			}
		});
		
		return checkoutinfo(barcode);
	}
	
	//get info to print out 
	private List<LibraryItemsNonAbstract> checkoutinfo(int barcode){
		String query = "SELECT title, checkoutTime, copiesavailable FROM libraryitems WHERE barcode = " + barcode;
		
		return jdbcTemplate.query(query, 
				(rs, rowNum) ->
				new LibraryItemsNonAbstract(
						rs.getString("title"),
						rs.getInt("checkoutTime"),
						rs.getInt("copiesavailable")));
	}
	
	//Return Items 
		//UPDATE libraryitems SET copiesavailable = (SELECT copiesavailable FROM libraryitems WHERE barcode = ?) + 1 WHERE barcode = ?;
	public String returnItem(int barcode) {
		String stmt = "UPDATE libraryitems SET copiesavailable = (SELECT copiesavailable FROM libraryitems WHERE barcode = ?) + 1 WHERE barcode = ?";
		
		jdbcTemplate.execute(stmt, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps)
				throws SQLException, DataAccessException{
					ps.setInt(1, barcode);
					ps.setInt(2, barcode);
					
					return ps.execute();
			}
		});
		
		return "Thank you for returning the item!";
	}
	
}
