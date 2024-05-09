You are designing a program to manage animals in a farm. A Farm has a linked list of animals. An animal has the following characteristic: age, color, and gender. The farm has the following types of animals: chicken, cows, goats, horses, lambs. All the animals have the method eat() but each of them implements it in a way that the method displays the amount of food that each type consumes per day (for example, a lamb consumes 2 kg, while a chicken consumes 0.25, etc.). A horse has a color. 

The program starts by displaying the following item:
1.	Add an animal
2.	Search for an animal
3.	Categorize
4.	Exit 
-	- - - - - - - - -- - - - -
Enter your choice:

If the user chooses 1 from the menu, the program prompts for information and creates an object of the appropriate type and adds it to the end of the list.

If the user chooses 2, the program prompts for the type and displays all animals of this particular type (for example, all horses).  

If the user chooses 3, the program sorts all animals by type (alphabetically) and displays the list. 

If the user chooses 4, the program terminates. 

Any other choice displays the menu again. If the user enters a choice outside the rang e[1,4], the menu is displayed again. If this is repeated more than 5 times, the program terminates. 
