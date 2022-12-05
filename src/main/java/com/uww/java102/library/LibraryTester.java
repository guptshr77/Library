package com.uww.java102.library;

// import statements
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.uww.java102.library.bo.LibraryActions;

@SpringBootApplication
public class LibraryTester {
	
	public static void main(String[] args) {
		
	    ConfigurableApplicationContext appContext = SpringApplication.run(LibraryTester.class, args);
	    LibraryActions la = appContext.getBean(LibraryActions.class);
	    
	    
		Scanner scan = new Scanner(System.in);
		
		//Intro to application
		System.out.println("Wecome to the Whitewater Public Library!");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("How may we help you?\n(enter the number that coresponds to the task you want)");
		System.out.println("\t1 - checkout\n\t2 - return\n\t3 - search\n\t4 - add item\n\t5 - remove item\n\t0 - quit");
		int option = Integer.parseInt(scan.nextLine());
		
		// loop to continually do different tasks 
		while(option != 0) {
		
			//check out item 
			if (option == 1) {
				
				la.checkoutItem(scan);
				
			}
			//return items that were checked out
			else if (option == 2) {
				
				la.returnItem(scan);
				
			}
			//search the database by title 
			else if (option == 3) {
				
				la.searchItem(scan);
				
			}
			//add items to the database
			else if (option == 4) {
				
				la.addItem(scan);
				
			}
			//remove items from the database
			else if (option == 5) {
				
				la.removeItem(scan);
				
			}
			//go through the while loop again 
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("How may we help you?\n(enter the number that coresponds to the task you want)");
			System.out.println("\t1 - checkout\n\t2 - return\n\t3 - search\n\t4 - add item\n\t5 - remove item\n\t0 - quit");
			
			option = Integer.parseInt(scan.nextLine());
			
		}
		
		// message when program is to be terminated 
		System.out.println("Library closed. Have a good day!");
		scan.close();

	}
	
}
