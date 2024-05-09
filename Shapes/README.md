In this problem, you are asked to write a program to define shapes of objects in space and store them in an array. For this, you have to define class Shape that you will extend into three specific types: Circle, Square, Triangle. Class Equilateral Triangle extends triangle. All shapes share the following members: color, x-coordinate, y-coordinate. They also share a common variable dimensions that is set to 2 for this instance of the problem since we are dealing with a two dimensional space. The last two instance fields specify the location of the object in a two-dimensional plane. A circle has a radius; a square has a side length. A triangle object has three fields to store the length of the sides of the triangle. An equilateral triangle is a triangle that has all three sides equal in length. Also, each of these shapes has a method called area () and one called perimeter () that compute the area and the perimeter, of each object depending on the shape.  In addition to this, they all have a method toString () that outputs the values in all the fields of an object.  It is possible to move triangles and squares but not circles. As you are proceeding with the design of the code, declare class Shape as abstract since you should not be able to instantiate it. 

The program starts by displaying the following menu:
1.	Add a shape
2.	Delete a shape
3.	Compute Area and Perimeter
4.	Display all
5.	Move an object
6.	Read from file
7.	Exit
- - - - - - - -
Enter your choice:

If the user enters 1, the following menu is displayed:
A.	Add a Circle
B.	Add a Square
C.	Add a Triangle
D.	Return to main menu
- -- - - - - - - -- - - - - -
Enter shape:

If the user enters A, the program prompts for the radius and x and y coordinates and adds a circle to the array. 

If the user enters B, the program prompts for the side length, x and y coordinates and adds a square to the array.

If the user enters C, the program prompts for the three sides, x and y coordinates and adds a triangle or equilateral triangle in case the three sides have equal length.

If the user enters D, the program returns to the previous menu.

The menu is displayed after each input except ‘D’. Any incorrect input should display an error message.

If the user enters 2, the program prompts for the x and y coordinates and deletes all shapes at the specified coordinates.

If the user enters 3, the program prompts for the x and y coordinates and compute and displays the area and perimeter of the shapes at these coordinates. 

If the user enters 4, the program displays all shapes in the array.

If the user enters 5, the program prompts for the distance by which the object is to move and whether the object should be moved vertically or horizontally, up or down if vertically, left or right if horizontally. It updates the x and y coordinates accordingly. All shapes should remain within a square that is 200 units wide and 200 units high.

If the user enters 6, the program reads shapes from a text file. The file should have the following format:

circle, red, 0, 1
square, blue, 2, 3
circle, green, 4, 2
triangle, yellow, 5, -3
equilateral triangle, pink, -1, -3

 If a line does not contain valid information, it should be skipped and a proper message should be displayed on the screen. The program should proceed to the next line though.

If the user enters 7, the program exits. Before terminating, the contents of the array are saved to a text file called output.txt.

The menu is displayed again after each correct input. Any incorrect input should output an error message and display the menu again.
