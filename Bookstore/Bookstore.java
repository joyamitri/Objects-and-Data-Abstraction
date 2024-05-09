package Bookstore;

import java.util.Scanner;

public class Bookstore {
    private Book[] books;
	private int count;

	public Bookstore() {
		// constructor to initialize the bookstore with a default size of 10 books
		books = new Book[10];
		count = 0;
	}

	public void add() {
		// adding a book to the bookstore
		if (count == books.length)
			// if array books is full, increase size
			increaseSize();

		// getting information and creating a new book
		System.out.println("Adding Book:");
		System.out.println("Enter the title of the book");
		Scanner scan = new Scanner(System.in);
		String title = scan.nextLine();
		System.out.println("Enter the author of the book");
		String author = scan.nextLine();

		Book new_book_check = new Book(title, author);

		// check if book already exist index=searchForBook(new_book);
		int index = searchForBook(new_book_check);

		if (index != -1) {
			// if book does exist increase the number of copies
			System.out.println("Book Already Exist, Incrementing the number of copies");
			books[index].setNumberOfCopies(books[index].getNumberOfCopies() + 1);
		} else {
			// if book does not exist add to bookstore
			System.out.println("Adding New Book");
			System.out.println("Enter the date of publication the book");
			String date_of_publication = scan.next();
			System.out.println("Enter the number of pages the book");
			int number_of_pages = scan.nextInt();
			System.out.println("Enter the number of copies the book");
			int number_of_copies = scan.nextInt();
			Book new_book = new Book(title, author, date_of_publication, number_of_pages, number_of_copies);
			books[count] = new_book;
			count++;
		}
	}

	private int searchForBook(Book book) {
		// check of book already exists in bookstore and return its index if found, else
		// return -1
		// this is not the find method but it's used in add and delete
		for (int i = 0; i < count; i++) {
			if (books[i].equals(book))
				return i;
		}
		return -1;

	}

	public void delete() {
		if (count == 0) {
			// if bookstore is empty no need to search
			System.out.println("Bookstore is Empty");
		} else {
			// getting title and author and searching for the book
			System.out.println("Deleting Book:");
			System.out.println("Enter the title of the book");
			Scanner scan = new Scanner(System.in);
			String title = scan.nextLine();
			System.out.println("Enter the author of the book");
			String author = scan.nextLine();
			Book book_to_delete = new Book(title, author);

			// check of book already exists in bookstore and return its index if found, else
			// return -1
			int index = searchForBook(book_to_delete);

			if (index == -1) {
				// if index is -1 the book is not found
				System.out.println("book not found");
			} else {
				// else get the number of copies
				int number_of_copies = books[index].getNumberOfCopies();
				if (number_of_copies > 1) {
					// if the number of copies is not zero decrement
					System.out.println("Book found, decrementing the number of copies");
					books[index].setNumberOfCopies(number_of_copies - 1);
				} else {
					// if the number of copies is zero delete from book store
					System.out.println("Book found, deleting book");
					count--;
					books[index] = books[count];
					books[count] = null;
				}

			}
		}
	}

	public void findBooks() {
		if (count == 0) {
			// if bookstore empty nothing to find
			System.out.println("Bookstore is Empty");
		} else {
			// else search for the title
			System.out.println("Enter the title of the book");
			Scanner scan = new Scanner(System.in);
			String title = scan.nextLine();
			int found = 0;
			for (int i = 0; i < count; i++) {
				/// if the book has the title print its information
				if (books[i].getTitle().equals(title)) {
					found++;
					System.out.println("Book found at index " + i + " " + books[i].toString());
				}
			}
			if (found == 0) {// feedback if not found
				System.out.println("Not found");
			}

		}
	}

	public void printList() {
		if (count == 0) {
			// if bookstore is empty nothing to print
			System.out.println("Bookstore is Empty");
		} else {
			// print all books information
			for (int i = 0; i < count; i++) {
				System.out.println(books[i].toString());
			}
		}
	}

	private void increaseSize() {
		// called when bookstore is full
		// copy the books to a larger array and return it
		Book[] temp = new Book[books.length * 2 + 1];
		for (int i = 0; i < books.length; i++)
			temp[i] = books[i];
		books = temp;
	}
}
