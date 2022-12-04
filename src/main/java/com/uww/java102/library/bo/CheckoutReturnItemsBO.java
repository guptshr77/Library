package com.uww.java102.library.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uww.java102.library.dal.CheckoutReturnItemsDAO;
import com.uww.java102.library.model.LibraryItemsNonAbstract;

@Component
public class CheckoutReturnItemsBO {
	@Autowired
	private CheckoutReturnItemsDAO drid;
	
	//checkout time 
	public LibraryItemsNonAbstract checkoutItemBO(int barcode) {
		List<LibraryItemsNonAbstract> lina =  drid.checkoutItem(barcode);
		if(lina.get(0).getCopiesAvailable() <= 0) {
			return new LibraryItemsNonAbstract(null, 0 , 0);
		}else {
			return lina.get(0);
		}
	} 
	//return item 
	public String returnItemBO(int barcode) {
		return drid.returnItem(barcode);
	}
	
}
