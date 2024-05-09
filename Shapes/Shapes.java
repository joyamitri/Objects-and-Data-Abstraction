package Shapes;

public abstract class Shapes {
    protected String color; 
	
	protected double x_coordinate; 
	
	protected double y_coordinate;
	
	public static int dimensions = 2;
	
	public Shapes(String Color, double X_coordinate, double Y_coordinate) {
		//constructor with all the characteristics 
		
		color = Color; 
		
		x_coordinate = X_coordinate; 
		
		y_coordinate = Y_coordinate; 
	}
	
	//getters and setters for the characteristics 
	
	public String getColor() {
		
		return color; 
	}
	
	public void setColor(String Color) {
		
		color = Color;
	}
	
	public double getXcoord() {
		
		return x_coordinate;
	}
	
	public void setXcoord(double X_coordinate) {
		
		x_coordinate = X_coordinate;
	}
	
	public double getYcoord() {
		
		return y_coordinate; 
	}
	
	public void setYcoord(double Y_coordinate) {
		
		y_coordinate = Y_coordinate;
	}
	
	public abstract double area();
	
	public abstract double perimeter();
	
	public abstract String toString();
}
