package Company;

public class Manager extends Employee{
    private String secretary; 
	
	private final double BONUS = 2.0 / 100.0;
	
	public Manager (String name, double salary, String hire_day, String Secretary) {
		//constructor with all the manager's characteristics
		
		super(name, salary, hire_day);
		
		secretary = Secretary; 
	}
	
	public String getSecretary() {
		//get the secretary's name 
		 
		return secretary; 
	}
	
	public void setSecretary(String Secretary) {
		//set the secretary's name
		
		secretary = Secretary; 
	}

	public String toString() {
		//return a string that displays all the information about the employee
		
		return super.toString() + ", Secretary: " + secretary;
	}
	
	public void computeRaise(float amount) {
		//compute the manager's salary after raise and bonus 
				
		salary += (amount * salary / 100.0);
		
		salary += (salary * BONUS);
		 
		
		
	}
}
