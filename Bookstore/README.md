You are asked to write a program to manage the books in a bookstore.  The program should consist of two classes: Book and BookStore. A bookstore is an object that has a collection of books. A book has a title (String), an author(String), a date of publication (String), a number of pages (int) and a number of copies(int). 

The program starts by displaying the following menu on the screen:

1. Add book
2. Delete book
3. Find book
4. List all
5. Exit
----------------------
Enter your choice:

The Add option:  If the user inputs 1, the program prompts for the characteristics of the book and searches for it. If the bookstore already has the book, the number of copies for this book is incremented. Otherwise, a book with the specified characteristics is created and added to the collection. Two books are considered equal if they have the same title and the same author.  For simplicity, we are going to ignore checking for the other fields.  

The Delete option: If the user enters 2, the program prompts for the title of the book and the name of the author. If the book is found in the bookstore, the number of copies is decremented by 1 and if it reaches 0, the book is removed from the collection. If the book is not found in the bookstore, a message is displayed to this effect.

The Find option: If the user inputs 3, the program prompts for the title of the book and displays all books with this title that exist in the bookstore.

The List option: If the user enters 4, the information of all the books is displayed, one book per line.  

The Exit option- If the user enters 5, the program terminates. 

The menu is displayed again after each option except the Exit option which terminates the program. 

Any choice from the menu other than 1,2, 3, 4 or 5  displays a message informing the user of the invalidity of the choice and prompts for it again.

There are two ways to end the program normally: either by having the user choose the Exit option or when an invalid choice is entered more than 5 consecutive times. 

Notes

•	Override the method toString()

•	If you need to compare two books for equality, make sure you implement the method equals(). Two books are equal if they have the same title and the same author. To compare two books, you should write: book1.equals(book2).
	
•	You may assume that the user will always enter the correct type of data (i.e. numbers   for number of copies, strings for author,  etc.).
