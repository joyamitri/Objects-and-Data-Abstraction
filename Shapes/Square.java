package Shapes;

public class Square extends Shapes{
    private double side_length; 
	
	public Square(String Color, double X_coordinate, double Y_coordinate, double Side_length) {
		//constructor with all characteristics
		
		super(Color, X_coordinate, Y_coordinate);
		
		side_length = Side_length; 
		
	}
	
	public Square(String Color, double X_coordinate, double Y_coordinate) {
		//constructor with only color and x-y coordinates 
		
		super(Color, X_coordinate, Y_coordinate);
		
	}
	
	//getters and setters for the characteristics

	public double getSideLength() {
		
		return side_length; 
	}
	
	public void setSideLength(double Side_length) {
		
		side_length = Side_length;
	}
	
	//implementation of the abstract methods inherited from the super-class
	
	public double area() {
		
		double computeArea = side_length * side_length; 
		
		return computeArea; 
	}
	
	public double perimeter() {
		
		double computePerimeter = 4 * side_length;
		
		return computePerimeter;
		
		
	}
	
	public String toString() {
		
		String toReturn = "Square, " + super.getColor() + ", " + super.getXcoord() + ", " + super.getYcoord();
		
		return toReturn;
	}
}
