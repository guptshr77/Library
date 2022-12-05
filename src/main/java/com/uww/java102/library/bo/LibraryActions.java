package com.uww.java102.library.bo;

import java.util.List;
import java.util.Scanner;

//import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uww.java102.library.model.AudioBooks;
import com.uww.java102.library.model.Books;
import com.uww.java102.library.model.Digital;
import com.uww.java102.library.model.LibraryItemsNonAbstract;
import com.uww.java102.library.model.Research;

@Component
public class LibraryActions {
	
	//autowired objects 
	@Autowired
	private SearchBO sb;
	@Autowired
	private AddRemoveBO arb;
	@Autowired
	private CheckoutReturnItemsBO crib;


	// method to checkout a library item
	public void checkoutItem(Scanner scan) {
		
		//get batcode of item they want to check out
		System.out.print("Enter the barcode number of the book you would like to check out: ");
		int barcode = Integer.parseInt(scan.nextLine());
		
		
		//call checkout item Business object
		LibraryItemsNonAbstract info = crib.checkoutItemBO(barcode);
		//if returned is null, book can't be checked out
		if(info.getTitle().equals(null)) {
			System.out.println("Sorry, this item is not available at this time");
		}else {
			//else checkout complete 
			System.out.println("Checkout Completed!");
			System.out.println("Return '" + info.getTitle() + "' in " + info.getCheckoutTime() + " days.");	
		}
	}
	
	//return items that were checked out
	public void returnItem(Scanner scan) {
		
		//get barcode 
		System.out.print("Enter the barcode number of the book you would like to return: ");
		int barcode = Integer.parseInt(scan.nextLine());
		
		//check if 
			String message = crib.returnItemBO(barcode);
			System.out.println(message);

	}
	
	//search database by title
	public void searchItem(Scanner scan) {
		//get input 
		System.out.println("What type of Item would you like to search for? \n"
				+ "(enter the letter that corresponds to what you want)");
		System.out.println("\tB - Book\n\tAB - Audiobook\n\tR - Research\n\tD - Digital Media\n");
		String searchItem = scan.nextLine(); //get what type 
		
		System.out.print("Enter the title of a library item you want to find (case sensitive): ");
		String title = scan.nextLine();
		
			// ADD PRINT OUT MATCHING ITEMS
			if (searchItem.equalsIgnoreCase("B")) {
				List<Books> books = sb.searchBookBO(title);
				for(Books b : books) {
					System.out.println(b.toString());
				}
			}else if (searchItem.equalsIgnoreCase("AB")) {
				List<AudioBooks> audiobooks = sb.searchAudioBookBO(title);
				for(AudioBooks ab: audiobooks) {
					System.out.println(ab.toString());
				}
				
			}else if (searchItem.equalsIgnoreCase("R")) {
				List<Research> research = sb.searchResearchBO(title);
				for(Research r: research) {
					System.out.println(r.toString());
				}
				
			}else {
				List<Digital> digital = sb.searchDigitalBO(title);
				for(Digital d: digital) {
					System.out.println(d.toString());
				}
				
			}

			// ADD ASKING USER FOR BARCODE NUMBER TO LOOK AT ITEM MORE CLOSELY 
			System.out.print("Please type in the barcode of the item you would like more details of: ");
			int barcode = Integer.parseInt(scan.nextLine());
			
			// ADD SHOW INDPETH SUMMARY
			if (searchItem.equalsIgnoreCase("B")) {
				List<Books> books = sb.searchBookMoreBO(barcode);
				for(Books b : books) {
					System.out.println(b.Summary());
				}
			}else if (searchItem.equalsIgnoreCase("AB")) {
				List<AudioBooks> audiobooks = sb.searchAudioBookMoreBO(barcode);
				for(AudioBooks ab: audiobooks) {
					System.out.println(ab.Summary());
				}
				
			}else if (searchItem.equalsIgnoreCase("R")) {
				List<Research> research = sb.searchResearchMoreBO(barcode);
				for(Research r: research) {
					System.out.println(r.Summary());
				}
				
			}else {
				List<Digital> digital = sb.searchDigitalMoreBO(barcode);
				for(Digital d: digital) {
					System.out.println(d.Summary());
				}
				
			}

	}
	
	public void addItem(Scanner scan) {

		String message = "";
		
		//get type of item to object
		System.out.println("What type of Item would you like to add to the library? \n"
				+ "(enter the letter that corresponds to what you want)");
		System.out.println("\tB - Book\n\tAB - Audiobook\n\tR - Research\n\tD - Digital Media");
		System.out.print("Type: ");
		String newitem = scan.nextLine(); 
		newitem = newitem.toUpperCase();
		
		System.out.print("\nEnter the title of the item: ");
		String title = scan.nextLine();

		System.out.print("\nEnter the number of copies: ");
		int copiesAvailable = Integer.parseInt(scan.nextLine());

		
		System.out.print("\nEnter the length of the item: ");
		String length = scan.nextLine();

		System.out.print("\nEnter the location it belongs in, in the library: ");
		String location = scan.nextLine();

		//if book
		if(newitem.contains("B")) {
			
			System.out.print("\nEnter the genre of the book: ");
			String genre = scan.nextLine();
			
			System.out.print("\nEnter the author of the book: ");
			String author = scan.nextLine();
			
			System.out.print("\nEnter the summary of the book: ");
			String summary = scan.nextLine();
			
			System.out.print("\nEnter the age range of the book: ");
			String ageRange = scan.nextLine();
			
			System.out.print("\nEnter the type of book (paper or audiobook):");
			String booktype = scan.nextLine();
			
			//if audiobook
			if(newitem.contains("A")) {
				
				System.out.print("\nEnter the speaker of the book: ");
				String speaker = scan.nextLine();
				
				AudioBooks audioBook = new AudioBooks(21, copiesAvailable, 
						length, location, title,"audiobook" , genre, author, summary, ageRange, booktype, speaker);
				
				message = arb.addAudioBookBO(audioBook);
			//if book
			}else {
				Books book = new Books(21, copiesAvailable, length, location,
						title,"book" , genre, author, summary, ageRange, booktype);
				message = arb.addBookBO(book);
			}	
		}
		//if research
		else if(newitem.equalsIgnoreCase("R")) {
			
			System.out.print("\nEnter the year the research book was published: ");
			int publishedDate = scan.nextInt();
			
			System.out.print("\nEnter the research topic: ");
			String topic = scan.nextLine();
			
			System.out.print("\nEnter the publisher of the research: ");
			String publisher = scan.nextLine();
			
			System.out.print("\nEnter the research material type: ");
			String type = scan.nextLine();
			
			Research research = new Research(15, copiesAvailable, length, 
					location, title,"research" , publishedDate, topic, publisher, type);
			message = arb.addResearchBO(research);
		}
		//if digital
		else if(newitem.equalsIgnoreCase("D")) {
			
			System.out.print("\nEnter the genre of the digital media: ");
			String genre = scan.nextLine();
			
			System.out.print("\nEnter the creator of the digital media: ");
			String creator = scan.nextLine();
			
			System.out.print("\nEnter the description of the digital media: ");
			String description = scan.nextLine();
			
			System.out.print("\nEnter the type of digital media: ");
			String type = scan.nextLine();
			
			Digital digital = new Digital(7, copiesAvailable, length,
					location, title,"digital" , genre, creator, description, type);
			message = arb.addDigitalBO(digital);
		}
		
		System.out.println(message);
	}
	
	//removes item 
	public void removeItem(Scanner scan) {
		
		System.out.print("Enter the barcode of a library item to remove: ");
		int barcode = Integer.parseInt(scan.nextLine());
		
		String message = "";
		
		String type = arb.getType(barcode);
		
		//What kind of object it is to call method to remove accordingly
		if(type.equals("audiobook")) {
			message = arb.removeAudioBookBO(barcode);
		}else if(type.equals("book")) {
			message = arb.removeBookBO(barcode);
		}else if(type.equals("research")) {
			message = arb.removeResearchBO(barcode);
		}else {
			message = arb.removeDigitalBO(barcode);
		}
		
		System.out.println(message);

		
	}

}
