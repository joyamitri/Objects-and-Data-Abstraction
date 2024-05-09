package Shapes;

public class Equilateral extends Shapes{
    private double l_side1;
	
	private double l_side2;
	
	private double l_side3;
	
	public Equilateral(String Color, double X_coordinate, double Y_coordinate, double L_side1, double L_side2, double L_side3) {
		//constructor with all characteristics
		
		super(Color, X_coordinate, Y_coordinate);
		
		l_side1 = L_side1;
		
		l_side2 = L_side2;
		
		l_side3 = L_side3;
	}

	public Equilateral(String Color, double X_coordinate, double Y_coordinate) {
		//constructor with only color and x-y coordinates
		
		super(Color, X_coordinate, Y_coordinate);
		
	}
	
	//getters and setters for the characteristics

	public double getL_side1() {
		
		return l_side1;
	}

	public void setL_side1(double L_side1) {
		
		l_side1 = L_side1;
	}

	public double getL_side2() {
		
		return l_side2;
	}

	public void setL_side2(double L_side2) {
		
		l_side2 = L_side2;
	}

	public double getL_side3() {
		
		return l_side3;
	}

	public void setL_side3(double L_side3) {
		
		l_side3 = L_side3;
	}
	
	//implementation of all the abstract methods inherited from the super-class
	
	public double area() {
		
		double pl = (3 * l_side1) / 2;
		
		double computeArea = Math.sqrt(pl * (Math.pow(pl - l_side1, 3)));
		
		return computeArea;
	}
	
	public double perimeter() {
		
		double computePerimeter = l_side1 * 3;
		
		return computePerimeter;
	}
	
	public String toString() {
		
		String toReturn = "Equilateral triangle, " + super.getColor() + ", " + super.getXcoord() + ", " + super.getYcoord();
		
		return toReturn;
	}
}
