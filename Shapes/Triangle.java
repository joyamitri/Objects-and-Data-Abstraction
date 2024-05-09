package Shapes;

public class Triangle extends Shapes{
    private double side1; 
	
	private double side2;
	
	private double side3;
	
	public Triangle(String Color, double X_coordinate, double Y_coordinate, double Side1, double Side2, double Side3) {
		//constructor with all characteristics
		
		super(Color, X_coordinate, Y_coordinate);
		
		side1 = Side1;
		
		side2 = Side2;
		
		side3 = Side3;
	}
	
	public Triangle(String Color, double X_coordinate, double Y_coordinate) {
		//constructor with only color and x-y coordinates
		
		super(Color, X_coordinate, Y_coordinate);
		
	}
	
	//getters and setters for all the characteristics

	public double getSide1() {
		
		return side1; 
	}
	
	public void setSide1(double Side1) {
		
		side1 = Side1; 
	}
	
	public double getSide2() {
		
		return side2;
	}
	
	public void steSide2(double Side2) {
		
		side2 = Side2;
	}
	
	public double getSide3() {
		
		return side3; 
	}
	
	public void setSide3(double Side3) {
		
		side3 = Side3;
		
	}
	
	//implementation of the abstract methods inherited from the super-class
	
	public double area() {
		
		double p = (side1 + side2 + side3) / 2;
		
		double computeArea = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
		
		return computeArea;
	}
	
	public double perimeter() {
		
		double computePerimeter = side1 + side2 + side3;
		
		return computePerimeter;
	}
	
	public String toString() {
		
		String toReturn = "Triangle, " + super.getColor() + ", " + super.getXcoord() + ", " + super.getYcoord();
		
		return toReturn; 
	}
}
