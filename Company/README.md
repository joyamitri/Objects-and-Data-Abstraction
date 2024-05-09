Write  a program to manage the employees of a company.  The program should contain three classes Employee, Manager and Company. The main method should be written in  class  Company. Class Company has a vector of employees. Each employee has a name (of type String), a hire day (of type String) and a salary (of type double).  Some employees can be managers. Each manager has a secretary (of type String).  

The program starts by displaying the following menu on the screen:

1.Add employee
2.Delete employee
3.Raise salary
4.List all
5.Exit

----------------------
Enter your choice:

The Add option –  If the user inputs 1, the program prompts for the name, salary, and hire day and whether the employee is a manager. If so, it prompts for the name of the secretary. An object of the appropriate type is created and added to the vector.

The Delete option- If the user enters 2, the program prompts for the name of the employee, searches for it and if it finds it, deletes the employee from the vector and then outputs a message saying that the record for the employee has been deleted. If the employee with the entered name is not found, an appropriate message is displayed. 

The Raise Salary option - If the user chooses Option 3, she/he is prompted for the name of the employee; if the employee is found, the user is prompted for the percentage by which the salary is to be raised and the salary is raised accordingly. If the employee is not found, an appropriate message is displayed. Raising the salary of a regular employee involves adding a certain percentage (that the user inputs) to the current salary whereas raising the salary of a manager involves adding a certain bonus after applying the raise.  To illustrate, if the user wants to raise the salary of an employee by 3%, a check is performed on the status of the employee, if it is a regular employee, the salary is incremented by 3%. If it is a manager, the salary is incremented by 3% first and then the new salary is incremented by 2%. The bonus (2) should be declared as a constant in the appropriate class. 

The List option - If the user enters 4, the information of all the employees is displayed, one employee per line. If the employee is a manager, the line is preceded by an M. 

The Exit option- If the user enters 5, the program terminates. 

The menu is displayed again after each option except the Exit option which terminates the program. 

Any choice from the menu other than 1,2, 3, 4 or 5  displays a message informing the user of the invalidity of the choice and prompts for it again.

There are two ways to end the program normally: either by having the user choose the Exit option or when an invalid choice is entered more than 5 consecutive times. 
