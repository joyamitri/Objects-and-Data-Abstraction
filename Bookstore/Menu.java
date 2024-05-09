package Bookstore;

import java.util.Scanner;

/*
  _______________________________________________________________________________________________________________________

  Program Description: This program's aim is to manage a bookstore by prompting the user to add, delete, find,
  and list one or more books.

  _______________________________________________________________________________________________________________________

*/

public class Menu {

    public static void main(String[] args) {
		// create a bookstore
		Bookstore bookstore = new Bookstore();
		int option = 1;
		int error_count = 0; // to track the wrong inputs
		Scanner option_scan = new Scanner(System.in);

		while (true) {
			// menu list
			System.out.println("______________________________________________________________________________________________________________________________________");
			System.out.println("(1).add book");
			System.out.println("(2).delete book");
			System.out.println("(3).find book ");
			System.out.println("(4).list all");
			System.out.println("(5).exit");
			System.out.println("choose an option");
			System.out.println("______________________________________________________________________________________________________________________________________");

			// get option from user
			option = option_scan.nextInt();

			switch (option) {
			case 1:
				// add book to bookstore
				bookstore.add();
				error_count = 0;// reset consecutive error count
				break;
			case 2:
				// delete book from bookstore
				bookstore.delete();
				error_count = 0;// reset consecutive error count
				break;
			case 3:
				// find books in bookstore
				bookstore.findBooks();
				error_count = 0;// reset consecutive error count
				break;
			case 4:
				// print books in bookstore
				bookstore.printList();
				error_count = 0;// reset consecutive error count
				break;
			case 5:
				// exiting
				System.out.println("Exiting");
				System.exit(0);
				break;
			default:
				if (error_count < 4) {// from 0 to 4=> 5 tries exists at the fifth error
					// if wrong input read again
					System.out.println("Invalid Value");
					error_count++;// increase consecutive error count
					int tries_left = 5 - error_count;
					String toPrint = tries_left == 1 ? "You have " + tries_left + " try left"
							: "You have " + tries_left + " tries left";
					System.out.println(toPrint);
					System.out.println("______________________________________________________________________________________________________________________________________");
				} else {
					// if 5 consecutive errors exit
					System.out.println("Too many trials. Exiting System.");
					System.exit(0);
				}
			}

		}

	}
    
}
