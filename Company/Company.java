package Company;

import java.util.Vector;
import java.util.Scanner;

public class Company {
    private Vector<Employee> employee; 
	
	public Company() {
		
		employee = new Vector<Employee>(10);
	}
	
	public Vector<Employee> getEmployee() {
		
		return employee;
	}



	public void setEmployee(Vector<Employee> employee) {
		
		this.employee = employee;
	}
	
	public void add() {
		//prompts the user for all the characteristics to add an employee
		
		Scanner scan_to_add = new Scanner (System.in);
		
		System.out.println("You are adding an employee!");
		
		System.out.println("Enter the name: ");
		
		String name_to_add = scan_to_add.nextLine();
		
		System.out.println("Enter the salary: ");
		
		double salary_to_add = Double.parseDouble(scan_to_add.nextLine());
		
		System.out.println("Enter the hire date: ");
		
		String hire_to_add = scan_to_add.nextLine();
		
		System.out.println("Enter \"yes\" if manager \"no\" if not: ");
		
		String if_manager = scan_to_add.nextLine();
		
		if(if_manager.equalsIgnoreCase("yes")) { //if manager prompt the user for the name of the secretary 
			
			System.out.println("Enter the name of the secretary: ");
			
			String secretary_to_add = scan_to_add.nextLine();
			
			Manager manager_to_add = new Manager(name_to_add, salary_to_add, hire_to_add, secretary_to_add);
			
			employee.addElement(manager_to_add); //add manager at the end of the vector 
			
			System.out.println("Manager successfully added!");
			
		}else if(if_manager.equalsIgnoreCase("no")) { // if not a manager 
			
			Employee employee_to_add = new Employee(name_to_add, salary_to_add, hire_to_add);
			
			employee.addElement(employee_to_add); //add employee at the end of the vector 
			
			System.out.println("Employee successfully added!");
		}
		
	}
	
	public int find(Employee employee_to_find) {
		
		for(int i = 0; i < employee.size(); i++) {
			
			if(employee.elementAt(i).equals(employee_to_find)) //search for the employee
				
				return i; //return index if found 
		}
		return -1; //return -1 if not found 
	}	
	
	public void delete() {
		//prompt the user for the name of the employee he wants to delete 
		
		Scanner scan_to_delete = new Scanner(System.in);
		
		System.out.println("Enter the name of the employee you want to delete: ");
		
		String name_to_delete = scan_to_delete.nextLine();
		
		Employee employee_to_delete = new Employee(name_to_delete);
		
		if(employee.size() == 0) //check if the company is empty 
			
			System.out.println("The company is empty! Add employees first");
		
		else {
			
			int index = find(employee_to_delete); //search for the employee
			
			if(index == -1)
				
				System.out.println("Employee not found!");
			
			else
				
				System.out.println(employee.remove(index) + " --> was deleted"); //remove the employee from the vector 
		}
		
	}
	
	public void listAll() {
		//display all employees
		
		if(employee.size() == 0) //check if the company is empty 
			
			System.out.println("The company is empty!");
		
		else {
			
			for(int i = 0; i < employee.size(); i++) {
				
				if(employee.elementAt(i) instanceof Manager) {//if manager display m before all the characteristics
					
					System.out.println("M-" + employee.elementAt(i).toString());
				}
				
				else
					
					System.out.println(employee.elementAt(i).toString());
			}
		}
	}
	
	public void computeSalary() {
		//compute the salary of the employee after raise 
		
		if(employee.size() == 0) // check if company is empty 
			
			System.out.println("The company is empty!");
		
		else {
			
			System.out.println("Raising salary...");
			
			Scanner scan_to_raise = new Scanner(System.in);
			
			System.out.println("Enter the name of the employee: ");
			
			String name_to_raise = scan_to_raise.nextLine();
			
			Employee employee_to_raise = new Employee(name_to_raise);
			
			int ind = find(employee_to_raise);
			
			if(ind == -1)
				
				System.out.println("Employee Not found");
			
			else {
				
				System.out.println("Enter the percentage of the raise: ");
				
				float p = Float.parseFloat(scan_to_raise.nextLine());
				
				if(employee.elementAt(ind) instanceof Manager) { //if manager compute salary with bonus 
					
					((Manager)employee.elementAt(ind)).computeRaise(p);
					
					System.out.println("Salary successfully raised!");
				}
				
				else {
					
					(employee.elementAt(ind)).raiseSalary(p); //if not, compute salary without bonus 
					
					System.out.println("Salary successfully raised!");
				}
			}
		}
	}



	public static void main(String[] args) {
		
		/*
_______________________________________________________________________________________________________________________

Program Description: This program aims to manage the employees and managers in a company using a vector. 

_______________________________________________________________________________________________________________________

*/
		
		Company company = new Company();
		
		int entry = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello! you are managing the company!");
		
		do {
			
			System.out.println("----------------------------------");
			
			System.out.println("1.Add an employee" + "\n" + "2.Delete an employee" + "\n" + "3.Raise salary" + "\n" + "4.list all" + "\n" + "5.Exit");
			
			System.out.println("----------------------------------");
			
			System.out.println("Enter a choice: ");
			
			int choice = scan.nextInt();
			
			switch(choice) {
			
			case 1:
				
				company.add();
				
				break; 
				
			case 2:
				
				company.delete();
				
				break; 
				
			case 3:
				
				company.computeSalary();
				
				break; 
				
			case 4:
				
				company.listAll();
				
				break; 
				
			case 5:
				
				System.out.println("Exiting...");
				
				System.exit(0);
			}
			
			
		}while(entry != 5);

	}
}
