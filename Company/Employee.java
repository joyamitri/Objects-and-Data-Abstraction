package Company;

public class Employee {
    protected String name;  
	
	protected double salary; 
	
	protected String hire_date;
	
	public Employee(String Name, double Salary, String Hire_date) {
		//constructor with all characteristics 
		
		name = Name; 
		
		salary = Salary;
		
		hire_date = Hire_date; 
		
		
	}
	
	public Employee(String Name) {
		//constructor with name only used for the raise salary and delete
		
		name = Name; 
	}
	
	public String getName() {
		//get the name of the employee
		
		return name; 
	}
	
	public void setName(String Name) {
		//change the name
		
		name = Name; 
	}
	
	public String getHiredate() {
		//get the hire date of the employee
		
		return hire_date; 
	}
	
	public void setHiredate(String Hire_date) {
		//change the hire date of the employee
		
		hire_date = Hire_date; 
	}
	
	public double getSalary() {
		//get the salary of the employee
		
		return salary;
	}
	
	public void setSalary(double Salary) {
		//change the salary of the employee
		
		salary = Salary; 
	}
	
	public boolean equals(Employee e) {
		//check if 2 employees have the same name 
		
		return(e.getName().equals(name));
	}
	
	public String toString() {
		//return a string with all the characteristics of an employee
		
		String toReturn = "Name: " + name + ", Salary: " + salary + "$" + ", Hire Date: " + hire_date;
		
		return toReturn; 
	}
	
	public void raiseSalary(float percentage) {
		//compute the raise of an employee
		
		salary += (percentage * salary / 100.0);
	}
}
