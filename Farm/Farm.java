package Farm;
/*
_______________________________________________________________________________________________________________________

Program Description: This program's aim is to manage a Farm by prompting the user add animals, search for a specific type of
 					  animal and categorize the animals in an alphabetical order.

_______________________________________________________________________________________________________________________

*/

import java.util.*;

public class Farm {
    // Declaring the attributes of the class Farm:
	private Node header;

	public Farm()
	// Initializing header to null
	{
		header = null;
	}

	public int displayAddType()
	// Displays the menu listing the possible type of animal that can be added to
	// the farm.
	// Returns the number of the desired type of animal.
	{
		int choice = -999;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. Add Cow");
			System.out.println("2. Add Goat");
			System.out.println("3. Add Lamb");
			System.out.println("4. Add Horse");
			System.out.println("5. Add Chicken");
			System.out.println("------------------");
			System.out.println("Which type of animal would you like to add?");
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(
					"\nNeed a number! There is only 5 possible choices 1, 2, 3, 4 or 5\nDisplaying main menu again...");
		}
		return choice;
	}

	public int displaySearchType()
	// Displays the menu listing the possible type of animal that can be searched in
	// the farm.
	// Returns the number of the desired type of animal.
	{
		int choice = -999;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. Search Cows");
			System.out.println("2. Search Goats");
			System.out.println("3. Search Lambs");
			System.out.println("4. Search Horses");
			System.out.println("5. Search Chickens");
			System.out.println("------------------");
			System.out.println("Which type of animal would you like to search?");
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(
					"\nNeed a number! There is only 5 possible choices 1, 2, 3, 4 or 5\nDisplaying main menu again...");
		}
		return choice;
	}

	public void addAnimal()
	// Adds an animal to the linked list by specifying first its type and storing
	// its age, color and gender.
	{
		try {
			Scanner scan = new Scanner(System.in);
			int choice = displayAddType();
			if (choice >= 1 && choice <= 5) {
				System.out.println("Enter the age of the animal desired to add: ");
				int age = Integer.parseInt(scan.nextLine());
				System.out.println("Enter the color of the animal desired to add: ");
				String color = scan.nextLine();
				String gender = "";
				do {
					System.out.println("Enter the gender of the animal desired to add: (male/female)");
					gender = scan.nextLine();
					gender = gender.toLowerCase();
				} while (!((gender.equals("male")) || (gender.equals("female"))));
				switch (choice) {
				case 1:
					Animal add_cow = new Cow(age, color, gender);
					if (header == null)
						header = new Node(add_cow);
					else {
						Node animal = header;
						while (animal.getNext() != null)
							animal = animal.getNext();
						animal.setNext(new Node(add_cow));
					}
					System.out.println("New Cow was added successfully!");
					break;

				case 2:
					Animal add_goat = new Goat(age, color, gender);
					if (header == null)
						header = new Node(add_goat);
					else {
						Node animal = header;
						while (animal.getNext() != null)
							animal = animal.getNext();
						animal.setNext(new Node(add_goat));
					}
					System.out.println("New Goat was added successfully!");
					break;

				case 3:
					Animal add_lamb = new Lamb(age, color, gender);
					if (header == null)
						header = new Node(add_lamb);
					else {
						Node animal = header;
						while (animal.getNext() != null)
							animal = animal.getNext();
						animal.setNext(new Node(add_lamb));
					}
					System.out.println("New Lamb was added successfully!");
					break;

				case 4:
					Animal add_horse = new Horse(age, color, gender);
					if (header == null)
						header = new Node(add_horse);
					else {
						Node animal = header;
						while (animal.getNext() != null)
							animal = animal.getNext();
						animal.setNext(new Node(add_horse));
					}
					System.out.println("New Horse was added successfully!");
					break;

				case 5:
					Animal add_chicken = new Chicken(age, color, gender);
					if (header == null)
						header = new Node(add_chicken);
					else {
						Node animal = header;
						while (animal.getNext() != null)
							animal = animal.getNext();
						animal.setNext(new Node(add_chicken));
					}
					System.out.println("New Chicken was added successfully!");
					break;
				}
			} else if (choice != -999)
				System.out.println("\nError!\nOnly available options 1, 2, 3, 4 or 5\nDisplaying main menu again...");
		} catch (NumberFormatException e) {
			System.out.println("\nNeed a number!\nDisplaying main menu again...");
		}
	}

	public int size()
	// returns the size of the linked list (how many animals are stored in the
	// linked list).
	{
		Node n = header;
		int count = 1;
		if (header == null)
			return 0;
		else {
			while (n.getNext() != null) {
				n = n.getNext();
				count++;
			}
			return count;
		}
	}

	public void searchType()
	// prints all the animals of the same type that the user asks for.
	{
		if (size() == 0)
			System.out.println("\nNo animal exists in the farm!");
		else {
			int choice = displaySearchType();
			Node n = header;
			int count = 0;
			int index_size = 0;
			switch (choice) {
			case 1:
				System.out.println("Cows that are added to the farm:");
				while (index_size < size()) {
					if (n.getNext() == null && n.getInfo() instanceof Cow && size() == 1) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					} else if (n.getInfo() instanceof Cow) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					}
					if (n.getNext() != null)
						n = n.getNext();
					index_size++;
				}
				if (count == 0)
					System.out.println("No cow exists in the farm!");
				break;

			case 2:
				System.out.println("Goat that are added to the farm:");
				while (index_size < size()) {
					if (n.getNext() == null && n.getInfo() instanceof Goat && size() == 1) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					} else if (n.getInfo() instanceof Goat) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					}
					if (n.getNext() != null)
						n = n.getNext();
					index_size++;
				}
				if (count == 0)
					System.out.println("No goat exists in the farm!");
				break;

			case 3:
				System.out.println("Lambs that are added to the farm:");
				while (index_size < size()) {
					if (n.getNext() == null && n.getInfo() instanceof Lamb && size() == 1) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					} else if (n.getInfo() instanceof Lamb) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					}
					if (n.getNext() != null)
						n = n.getNext();
					index_size++;
				}
				if (count == 0)
					System.out.println("No lamb exists in the farm!");
				break;

			case 4:
				System.out.println("Horses that are added to the farm:");
				while (index_size < size()) {
					if (n.getNext() == null && n.getInfo() instanceof Horse && size() == 1) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					} else if (n.getInfo() instanceof Horse) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					}
					if (n.getNext() != null)
						n = n.getNext();
					index_size++;
				}
				if (count == 0)
					System.out.println("No horse exists in the farm!");
				break;

			case 5:
				System.out.println("Chickens that are added to the farm:");
				while (index_size < size()) {
					if (n.getNext() == null && n.getInfo() instanceof Chicken && size() == 1) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					} else if (n.getInfo() instanceof Chicken) {
						count++;
						System.out.println(count + "- " + n.getInfo().toString());
					}
					if (n.getNext() != null)
						n = n.getNext();
					index_size++;
				}
				if (count == 0)
					System.out.println("No chicken exists in the farm!");
				break;

			case -999:
				break;

			default:
				System.out.println("\nError!\nOnly available options 1, 2, 3, 4 or 5\nDisplaying main menu again...");
				break;
			}
		}
	}

	public void categorizeAnimal()
	// prints all the stored animals in the farm, by sorting them in an alphabetical
	// order depending on
	// the type of the animal so by following this order: chicken, cow, goat, horse,
	// lamb
	{
		if (size() == 0)
			System.out.println("\nNo animal exists in the farm!");
		else {
			Node n = header;
			int count = 0;
			int index_size = 0;
			int count_chicken = 0;
			int count_cow = 0;
			int count_goat = 0;
			int count_horse = 0;
			int count_lamb = 0;
			System.out.println("Animals in this farm:\n");
			System.out.println("Chickens:");
			System.out.println("__________");
			while (index_size < size()) {
				if (n.getNext() == null && n.getInfo() instanceof Chicken && size() == 1) {
					count_chicken++;
					System.out.println(count_chicken + "- " + n.getInfo().toString());
				} else if (n.getInfo() instanceof Chicken) {
					count_chicken++;
					System.out.println(count_chicken + "- " + n.getInfo().toString());
				}
				if (n.getNext() != null)
					n = n.getNext();
				index_size++;
			}
			if (count_chicken == 0)
				System.out.println("No chicken registered in this farm\n");

			System.out.println("Cow:");
			System.out.println("____");
			n = header;
			index_size = 0;
			while (index_size < size()) {
				if (n.getNext() == null && n.getInfo() instanceof Cow && size() == 1) {
					count_cow++;
					System.out.println(count_cow + "- " + n.getInfo().toString());
				} else if (n.getInfo() instanceof Cow) {
					count_cow++;
					System.out.println(count_cow + "- " + n.getInfo().toString());
				}
				if (n.getNext() != null)
					n = n.getNext();
				index_size++;
			}
			if (count_cow == 0)
				System.out.println("No cow registered in this farm\n");

			System.out.println("Goat:");
			System.out.println("______");
			n = header;
			index_size = 0;
			while (index_size < size()) {
				if (n.getNext() == null && n.getInfo() instanceof Goat && size() == 1) {
					count_goat++;
					System.out.println(count_goat + "- " + n.getInfo().toString());
				} else if (n.getInfo() instanceof Goat) {
					count_goat++;
					System.out.println(count_goat + "- " + n.getInfo().toString());
				}
				if (n.getNext() != null)
					n = n.getNext();
				index_size++;
			}
			if (count_goat == 0)
				System.out.println("No goat registered in this farm\n");

			System.out.println("Horse:");
			System.out.println("______");
			n = header;
			index_size = 0;
			while (index_size < size()) {
				if (n.getNext() == null && n.getInfo() instanceof Horse && size() == 1) {
					count_horse++;
					System.out.println(count_horse + "- " + n.getInfo().toString());
				} else if (n.getInfo() instanceof Horse) {
					count_horse++;
					System.out.println(count_horse + "- " + n.getInfo().toString());
				}
				if (n.getNext() != null)
					n = n.getNext();
				index_size++;
			}
			if (count_horse == 0)
				System.out.println("No horse registered in this farm\n");

			System.out.println("Lamb:");
			System.out.println("_____");
			n = header;
			index_size = 0;
			while (index_size < size()) {
				if (n.getNext() == null && n.getInfo() instanceof Lamb && size() == 1) {
					count_lamb++;
					System.out.println(count_lamb + "- " + n.getInfo().toString());
				} else if (n.getInfo() instanceof Lamb) {
					count_lamb++;
					System.out.println(count_lamb + "- " + n.getInfo().toString());
				}
				if (n.getNext() != null)
					n = n.getNext();
				index_size++;
			}
			if (count_lamb == 0)
				System.out.println("No lamb registered in this farm\n");
		}
	}

	public int displayMainMenu()
	// Displays the main menu of the program, showing the possible tasks that the
	// program can do: add,
	// search and categorize. Returns the number of the desired task.
	{
		int choice = 0;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. Add an animal");
			System.out.println("2. Search for an animal");
			System.out.println("3. Categorize");
			System.out.println("4. Exit");
			System.out.println("--------------------------");
			System.out.println("Enter choice: ");
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("\nNeed a number");
		}
		return choice;

	}
	// Main method:

	public static void main(String[] args) {
		Farm f = new Farm();
		boolean program = true;
		int count_error = 0; // in this assignment it was not specified that it should be consecutive errors
								// I assumed it to be as if we have not more than 5 chances
		do {
			int choice = f.displayMainMenu();
			switch (choice) {
			case 1:
				f.addAnimal();
				System.out.println();
				break;

			case 2:
				f.searchType();
				System.out.println();
				break;

			case 3:
				f.categorizeAnimal();
				System.out.println();
				break;

			case 4:
				System.out.println("Shutting down...");
				program = false;
				break;

			default:
				count_error++;
				if (count_error == 6) {
					System.out.println("\nYou have typed more than 5 invalid choices\nProgram shutting down...");
					program = false;
				} else
					System.out.println(
							"\nError! Invalid choice This program has only 4 options 1, 2, 3 or 4\nDisplaying main menu again...\n");

			}
		} while (program);
	}
}
