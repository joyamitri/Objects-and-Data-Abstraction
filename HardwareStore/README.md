A hardware store sells computers, printers and scanners. Computers can be either desktop computers or PCs. The hardware store maintains a linked lists of all the items it holds in the store. An item has a price and a brand. A computer has on top of these characteristics a CPU brand, a CPU speed, Hard Disk capacity and RAM capacity. A printer has a field indicating whether it is colored or monochrome and one indicating whether it is inkjet or laser-jet. A scanner has a field indicating if it is colored or not and one indicating if it is single feed or multi-feed. 

Computers can be compared according to their price. Only computers are comparable and hence can be sorted.  Scanners and printers cannot be compared to any other item that the store holds and hence computers must have the method compareTo() implemented in them. 

Write a program that reads the information about the items from a text file and uploads the items in a linked list. The program then starts by displaying the following menu:
1.	add an item 
2.	remove an item
3.	sort computers
4.	count assets
5.	reverse list
6.	Exit
--------------------
	Input  your choice:


•	Choice 1 allows the user to add an item manually to the list. The item is added at the end of the list.
•	Choice 2 prompts the user for the type of item, displays all items of this specific type and ask for the index of the item to remove. The item at the specified index is then removed from the list. 
•	Choice 3 creates a list of  computers only and sorts the list in a descending order of their price. To do this,  the program uses insertion sort that you have seen in CSC/BIF 243 (shown below). It then displays the list sorted. This option must invoke method sort() that takes an array of type Sortable only. 
•	Choice 4 displays how many instances of each item the store holds, the price per item (e.g. $4,000 worth of printers, 2,000$ worth of scanner, 60,000$ worth of laptops, etc.) and the total value of the items it is currently holding.
•	Choice 5 reverses the list of items and returns the reversed list.

•	Choice 6 exits the program. 

The menu is displayed again after choice 1 to 5.  Any invalid choice will display the menu again. If the user inputs three consecutive invalid choices, the program terminates. 

 
insertion sort: this sorting algorithm starts by comparing the two elements and swap them if needed. then it checks element at index 2 and inserts it where it belongs between elements at indices 0 and 1, proceeds with element at index 3, until the end of the list. In other words, at each iteration, it considers element at index i and insets it where it belongs among elements at indices from 0 to i-1. 
