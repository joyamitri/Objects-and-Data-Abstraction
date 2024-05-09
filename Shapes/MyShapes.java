package Shapes;

import java.util.Scanner;
import java.io.*;

public class MyShapes {
    private Shapes[] shapes;
	
	private int count; 
	
	public MyShapes() {
		//constructor to initialize the array of shapes with a specific size 
		
		shapes = new Shapes[10];
		
		count = 0; 
	}

	public Shapes[] getShapes() {
		
		return shapes;
	}

	public void setShapes(Shapes[] SHapes) {
		
		shapes = SHapes;
	}

	public int getCount() {
		
		return count;
	}

	public void setCount(int Count) {
		
		count = Count;
	}
	
	public void increaseSize() {
		//method to increase the size of the array if full 
		
		Shapes [] temp = new Shapes[shapes.length * 2 + 1];
		
		for(int i = 0 ; i < shapes.length; i++) {
			
			temp [i] = shapes[i]; //copy everything that is in the array to a temporary one that twice its size
		}
		
		shapes = temp; 
		
	}
	
	public void addCircle() {
		
		//add a circle to the array 
		
		if(count == shapes.length)
			//checks if its full 
			
			increaseSize();
		
		else {
			//prompts the user for all the characteristics needed 
			
			Scanner scan_circle = new Scanner(System.in);
			
			System.out.println("You're adding a circle!");
			
			System.out.println("Enter the color of the circle: ");
			
			String col = scan_circle.nextLine();
			
			System.out.println("Enter the radius of the circle: ");
			
			double rad = Double.parseDouble(scan_circle.nextLine());
			
			System.out.println("Enter the x coordinate of the circle: ");
			
			double x_coord = Double.parseDouble(scan_circle.nextLine());
			
			System.out.println("Enter the y coordinate of the circle: ");
			
			double y_coord = Double.parseDouble(scan_circle.nextLine());
			
			//creates an object of type Circle 
			
			Circle circle = new Circle(col, x_coord, y_coord, rad);
			
			//adds circle to the array 
			
			shapes[count] = circle;
			
			count++;
			
			System.out.println("Circle was successfully added!");
		}
		
		
	}
	
	public void addSquare() {
		//to add a square to the array of shapes 
		
		if(count == shapes.length)
			//checks if the array is full 
			
			increaseSize();
		
		else {
			
			//prompts the user for all the characteristics needed 
			
			Scanner scan_square = new Scanner(System.in);
			
			System.out.println("You're adding a square!");
			
			System.out.println("Enter the color of the square: ");
			
			String s_col = scan_square.nextLine();
			
			System.out.println("Enter the side length of the square: ");
			
			double side_len = Double.parseDouble(scan_square.nextLine());
			
			System.out.println("Enter the x coordinate of the square: ");
			
			double s_x_coord = Double.parseDouble(scan_square.nextLine());
			
			System.out.println("Enter the y coordinate of the square: ");
			
			double s_y_coord = Double.parseDouble(scan_square.nextLine());
			
			//creates an object of type Square
			
			Square square = new Square(s_col, s_x_coord, s_y_coord, side_len);
			
			//adds the square to the array 
			
			shapes[count] = square;
			
			count++;
			
			System.out.println("Square successfully added!");
			
			
		}
	}
	
	public void addTriangle() {
		
		//to add a triangle
		
		if(count == shapes.length)
			//checks if array is full 
			
			increaseSize();
		
		else {
			//prompts the user for all the characteristics needed 
			
			Scanner scan_triangle = new Scanner(System.in);
			
			System.out.println("You're adding a triangle!");
			
			System.out.println("Enter the color of the triangle: ");
			
			String t_col = scan_triangle.nextLine();
			
			System.out.println("Enter the side length 1 of the triangle: ");
			
			double side_len1 = Double.parseDouble(scan_triangle.nextLine());
			
			System.out.println("Enter the side length 2 of the triangle: ");
			
			double side_len2 = Double.parseDouble(scan_triangle.nextLine());
			
			System.out.println("Enter the side length 3 of the triangle: ");
			
			double side_len3 = Double.parseDouble(scan_triangle.nextLine());
			
			System.out.println("Enter the x coordinate of the triangle: ");
			
			double t_x_coord = Double.parseDouble(scan_triangle.nextLine());
			
			System.out.println("Enter the y coordinate of the triangle: ");
			
			double t_y_coord = Double.parseDouble(scan_triangle.nextLine());
			
			if(side_len1 == side_len2 && side_len1 == side_len3) { // if all the sides are equal -> equilateral triangle
				
				//creates an object of type Equilateral 
				
				Equilateral equilateral = new Equilateral(t_col, t_x_coord, t_y_coord, side_len1, side_len2, side_len3);
				
				//adds it to the array 
				
				shapes[count] = equilateral;
				
				count++;
				
				System.out.println("Equilateral triangle successfully added!");
			}
			
			else { //if the sides are not equal -> triangle
				
				//creates an object of type Triangle
				
				Triangle triangle = new Triangle(t_col, t_x_coord, t_y_coord, side_len1 , side_len2, side_len3);
				
				//adds it to the array 
				
				shapes[count] = triangle;
				
				count++;
				
				System.out.println("triangle successfully added");
			
			}
			
			
		}
		
		
	}
	
	public void deleteShape() {
		//deletes a shape from the array 
		
		if(count == 0)
			//checks if empty 
			
			System.out.println("No shapes found!");
		
		else {
			//prompts the user for all the characteristics needed
			
			Scanner scan_del = new Scanner(System.in);
			
			System.out.println("You are deleting shapes with specific coordinates.");
			
			System.out.println("Enter the x coordinate of the shapes you want to delete: ");
			
			double x_delete = scan_del.nextDouble();
			
			System.out.println("Enter the y coordinate of the shapes you want to delete: ");
			
			double y_delete = scan_del.nextDouble();
			
			int temp_counter = count;
			
			for(int i = 0; i < temp_counter; i++) {
				
				if(shapes[i].getXcoord() == x_delete && shapes[i].getYcoord() == y_delete) { //search for a match 
					
					shapes[i] = null; //deletes the shape 
					
					count--; 
				}
			}
			
			Shapes[] temp_shapes = new Shapes[shapes.length];
			
			int index = 0;
			
			for(int i = 0; i < shapes.length; i++) {
				
				if(shapes[i] != null) { //removes null from the middle of the array 
					
					temp_shapes[index] = shapes[i];
					
					index++;
				}
			}
			
			shapes = temp_shapes;
		}
	}
	
	public void computeAreaPerimeter() {
		//to compute the area and the perimeter for a specific shape
		
		if(count == 0) {
			//checks if empty
			
			System.out.println("No shapes found!");
		}
		
		else {
		
		//prompts the user for all the characteristics needed 
		
		Scanner scan_coord = new Scanner(System.in);
		
		System.out.println("You are computing the area and perimeter of a shape. ");
		
		System.out.println("Enter the x coordinates of the shapes: ");
		
		double x = scan_coord.nextDouble();
		
		System.out.println("Enter the y coordinates of the shapes: ");
		
		double y = scan_coord.nextDouble();
		
		for (int i = 0; i < count; i++) {
			
			if(shapes[i].getXcoord() == x && shapes[i].getYcoord() == y) { //checks for a match 
				
				System.out.println("Area of " + shapes[i].toString() + " is: " + shapes[i].area());
				
				System.out.println("Perimeter of " + shapes[i].toString() + " is: " + shapes[i].perimeter());
				
			}
		}
		}
	}
	
	public void displayAll() {
		//prints everything in the array 
		
		if(count == 0) {
			//checks if empty
			
			System.out.println("No shapes found!");
		}
		
		else {
			
			for(int i = 0; i < count; i++) {
				
				System.out.println(shapes[i].toString());
				
			}
		}
	}
	
	public void moveObject() {
		
		//moves an object n units
		
		if(count == 0)
			
			//checks if empty
			
			System.out.println("No shapes found!");
		
		else {
			
			//prompts the user for all the info needed
			
		Scanner scan_move = new Scanner(System.in);
		
		System.out.println("Enter the distance by which you want to move the object: ");
		
		double move = Double.parseDouble(scan_move.nextLine());
		
		if(Math.abs(move) > 200) { //checks if input greater than 200
			
			System.out.println("Cannot move beyond 200 units wide and high!");
			
		}
		
		else {
			//prompts for all the info needed 
			System.out.println("Do you want it to move vertically or horizontally? ");
			
			String direction = scan_move.nextLine();
			
			if(direction.equalsIgnoreCase("vertically")) {
				
				System.out.println("up or down? ");
				
				String d = scan_move.nextLine();
				
				if(d.equalsIgnoreCase("up")) {
					
					for(int i = 0; i < count; i++) {
						
						shapes[i].setYcoord(shapes[i].getYcoord() + move); //move n units up 
						
					}
					
				}else if(d.equalsIgnoreCase("down")) {
					
					for(int i = 0; i < count; i++) {
						
						shapes[i].setYcoord(shapes[i].getYcoord() - move); //move n units down 
						
					}
					
				}
				
				else {
					
					System.out.println("Invalid choice!");
				}
					
			}else if(direction.equalsIgnoreCase("horizontally")) {
				
				System.out.println("left or right? ");
				
				String d2 = scan_move.nextLine();
				
				if(d2.equalsIgnoreCase("left")) {
					
					for(int i = 0; i < count; i++) {
						
						shapes[i].setXcoord(shapes[i].getXcoord() - move); //move n units left
					}
				}else if(d2.equalsIgnoreCase("right")) {
					
					for(int i = 0; i < count; i++) {
						
						shapes[i].setXcoord(shapes[i].getXcoord() + move); //move n units right
					}
					
					
				}
				
				else {
					
					System.out.println("Invalid choice!");
				}
			}
			
			else {
				
				System.out.println("Invalid choice");
			}
			
			
		}
			
		}
		
		
	}
	
	public void readFile() {
		
		try {
			
			Scanner scan = new Scanner(new FileReader("input")); //file reader  
			
			do {
				
				String line = scan.nextLine(); //read line by line 
				
				String[] words = line.split(", "); //split and store the content of the file in the array 
				
				if(words[0].equalsIgnoreCase("circle")) {
					//creates an object of type circle and stores it in shapes 
					
					Shapes circle = new Circle(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]));
					
					shapes[count] = circle;
					
					count++;
				}else if(words[0].equalsIgnoreCase("square")) {
					//creates an object of type square and stores it in shapes
				
					Shapes square = new Square(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]));
					
					shapes[count] = square;
					
					count++;
				}else if(words[0].equalsIgnoreCase("triangle")) {
					//creates an object of type triangle and stores it in shapes
					
					Shapes triangle = new Triangle(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]));
					
					shapes[count] = triangle;
					
					count++;
			}else if(words[0].equalsIgnoreCase("equilateral triangle")) {
				//creates an object of type equilateral triangle and stores it in shapes
					
					Shapes equilateral = new Equilateral(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]));
					
					shapes[count] = equilateral;
					
					count++;
				}
				
			}while(scan.hasNextLine());
			
			scan.close();
			
			
		}catch(IOException e) { //if file not found
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
	}
	
	public void exit() {
		
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter("output"));// file writer 
			
			for(int i = 0; i < count; i ++) {
				
				outFile.println(shapes[i].toString()); //write everything stored in shapes to the output file
				
			}
			
			outFile.close();
			
		} catch (IOException e) { //if file not found
			
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
    }
    public static void main(String[] args) {
		
		/*
_______________________________________________________________________________________________________________________

Program Description: This program's aim is to adjust an array of shapes by reading from a file and prompting the user for
different options. 

_______________________________________________________________________________________________________________________

*/
		
		MyShapes myShapes = new MyShapes();
		
		Scanner scan_choice2 = new Scanner(System.in);
		
		Scanner scan_choice1 = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1. Add a shape" + "\n" + "2. Delete a shape" + "\n" + "3. Compute Area and Perimeter" + "\n" + "4. Display All" + "\n" + "5. Move an object" + "\n" + "6. Read from file" + "\n" + "7. Exit");
			
			System.out.println("------------------------------------------");
			
			System.out.println("Enter your choice: ");
			
			int choice = scan_choice1.nextInt(); 
			
			switch(choice) {
			
			case 1:
				
				System.out.println("A. Add a Circle" + "\n" + "B. Add a Square" + "\n" + "C. Add a Triangle" + "\n" + "D. Return to main menu");
				
				System.out.println("------------------------");
				
				System.out.println("Enter your choice: ");
				
				String choice_2 = scan_choice2.next();
				
				switch(choice_2) {
				
				case "A":
					
					myShapes.addCircle();
					
					break;
				
				case "B":
					
					myShapes.addSquare();
					
					break;
					
				case "C":
					
					myShapes.addTriangle();
					
					break; 
					
				case "D":
					
					System.out.println("Returning to main menu...");
					
					break;
					
				default: 
					
					System.out.println("Enter a valid letter!");
					
					break;
					
				}
				
				break;
			
			case 2: 
				
				myShapes.deleteShape();
				
				break;
				
			case 3:
				
				myShapes.computeAreaPerimeter();
				
				break;
				
			case 4:
				
				myShapes.displayAll();
				
				break;
				
			case 5:
				
				myShapes.moveObject();
				
				break;
				
			case 6:
				
				myShapes.readFile();
				
				break;
				
			case 7:
				
				myShapes.exit();
				
				System.out.println("Exiting...");
				
				System.exit(0);
				
				break;
				
			default:
				
				System.out.println("Enter a valid number!");
			}
		}
		
	}
}
