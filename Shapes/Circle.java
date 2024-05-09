package Shapes;

public class Circle extends Shapes{
    private double radius;
	
	public Circle(String Color, double X_coordinate, double Y_coordinate, double Radius) {
		//constructor with all characteristics
		
		super(Color, X_coordinate, Y_coordinate);
		
		radius = Radius; 
	}
	
	public Circle(String Color, double X_coordinate, double Y_coordinate) {
		//constructor with only color and x-y coordinates
		
		super(Color, X_coordinate, Y_coordinate);
		
	}
	
	//getters and setter for the characteristics

	public double getRadius() {
		
		return radius;
	}
	
	public void setRadius(double Radius) {
		
		radius = Radius;
	}
	
	//implementation of the abstract methods inherited from the super-class
	
	public double area() { 
		
		double computeArea = Math.PI * (radius * radius);
		
		return computeArea;
		
	}
	
	public double perimeter() {
		
		double computePerimeter = 2 * Math.PI * radius;
		
		return computePerimeter;
	}
	
	public String toString() {
		
		String toReturn = "Circle, " + super.getColor() + ", " + super.getXcoord() + ", " + super.getYcoord();
		
		return toReturn;
	}
}
