package HardwareStore;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
_______________________________________________________________________________________________________________________

Program Description: This program's aim is to perform have a linkedlist that handles a hardware store with PCs, Laptops, Scanners and Printers.
It adds, delete, sort computers by price, shows all the assets, and reverse the linkedlist.
_______________________________________________________________________________________________________________________

 */

public class Menu {

	public static void sort(Sortable[] items) {
		// sorts an array of items in an decreasing order as specified in the compareTo() method
		
		System.out.println("Before sorting");
		show(items);
		System.out.println("-----------------------------------------------------");

		for (int i = 1; i < items.length; i++) {
			if (items[i] != null) {
				Sortable key = items[i];
				int position = i;
				while (position > 0 && key.compareTo(items[position - 1]) > 0) {
					items[position] = items[position - 1];
					position--;
				}
				items[position] = key;
			}
		}
	}

	public static void show(Sortable[] items) {
		// print the array 
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null)
				System.out.println(items[i]);
		}
	}
	public  void show_delete(Items[] items) {
		// show the array when deleting
		int ind=0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				
				System.out.println("index ("+ind+") "+ items[i]);
				ind++;
			}
		}
	}

	public void menu() {
		// Displays the menu
		System.out.println("1.Add an item\r\n" + "2.Delete an item\r\n" + "3.Sort computers\r\n"
				+ "4.Display all assets\r\n" + "5. Reverse \r\n" + "6.Exit\r\n" + "Enter your choice:");
		System.out.println("--------------------------------------");
	}

	// Method to insert a new node
	public Node insert(Node head, Items item) {
		// Create a new node with given data
		Node new_node = new Node(item);

		// If the Linked List is empty,
		// then make the new node as head
		if (head == null) {
			head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = head;
			while (last.getNext() != null) {
				last = last.getNext();
			}

			// Insert the new_node at last node
			last.setNext(new_node);
		}

		// Return the list by head
		return head;
	}

	// Method to delete a  node
	public Node delete(Node head, int index) {

		// If the Linked List is empty,
		// return
		if (head == null) {
			System.out.println("empty cant delete");
			return head;
		} else {
			// Else traverse till the index and delete
			Node current = head;
			Node prev=null;
			int count = 0;
			while (current.getNext() != null && count < index) {
				prev=current;
				current = current.getNext();
				count++;
			}

			if (current.getNext() != null && prev !=null) {
				prev.setNext(current.getNext());
				System.out.println("Deleted at index: " + index);
			} else {
				System.out.println("index not found max index is: " + count);
			}
		}

		print(head);
		// Return the list by head
		return head;
	}

	//Displays assets
	public void getAll(Node head) {
		if (head == null) {
			System.out.println("empty cant delete");

		} else {
			// Else traverse till the last node
			// and sum for each type
			int count_scanners = 0;
			int count_printers = 0;
			int count_PCs = 0;
			int count_laptops = 0;

			Node last = head;
			while (last != null) {
				if (last.getItem() instanceof Printers) {
					count_printers += last.getItem().getPrice();
				} else if (last.getItem() instanceof Scanners) {
					count_scanners += last.getItem().getPrice();
				} else if (last.getItem() instanceof PCs) {
					count_PCs += last.getItem().getPrice();
				} else if (last.getItem() instanceof Laptops) {
					count_laptops += last.getItem().getPrice();
				}
				last = last.getNext();
			}

			System.out.println("The store include " + count_printers + "$ worth of printers," + count_scanners
					+ "$ worth of scanner," + count_PCs + "$ worth of PCs, " + count_laptops + " $ worth of laptops");
		}

	}
	
	public Object[] getType(Node head, int type) {
		// return based on the specific type
		int[] index= new int[100];
		Items[] c = new Items[100];
		if (head == null) {//if empty
			System.out.println("empty cant get");
			return null;

		} else {

			// Else traverse till the last node
			if(type==1) {// if PC

			Node last = head;
			int count = 0;
			int index_c=0;
			while (last != null) {
				
				if (last.getItem() instanceof PCs) {
					c[count] = (Items) last.getItem();
					index[count]=index_c;
					count++;}
				last = last.getNext();
				index_c++;
			}

		}
			if(type==2) {// If laptop

				Node last = head;
				int count = 0;
				int index_c=0;
				while (last != null) {
					
					if (last.getItem() instanceof Laptops) {
						c[count] = (Items) last.getItem();
						index[count]=index_c;
						count++;}
					last = last.getNext();
					index_c++;
				}

			}
			if(type==3) {//if printer

				Node last = head;
				int count = 0;
				int index_c=0;
				while (last != null) {
					
					if (last.getItem() instanceof Printers) {
						c[count] = (Items) last.getItem();
						index[count]=index_c;
						count++;}
					last = last.getNext();
					index_c++;
				}

			}
			if(type==4) {// if scanners

				Node last = head;
				int count = 0;
				int index_c=0;
				while (last != null) {
					
					if (last.getItem() instanceof Scanners) {
						c[count] = (Items) last.getItem();
						index[count]=index_c;
						count++;}
					last = last.getNext();
					index_c++;
				}

			}
			Object[] objs= {c, index};
			return objs;
		}

		
	}


	public Computers[] getComputers(Node head) { //retutn all computers
		Computers[] c = new Computers[100];
		if (head == null) {// if empty
			System.out.println("empty cant get");
			return null;

		} else {

			// Else traverse till the last node
			// and sum for each type

			Node last = head;
			int count = 0;
			while (last != null) {
				if (last.getItem() instanceof PCs) {
					c[count] = (Computers) last.getItem();
					count++;
				} else if (last.getItem() instanceof Laptops) {
					c[count] = (Computers) last.getItem();
					count++;
				}
				last = last.getNext();
			}

		}

		return c;
	}

	Node reverse(Node head) {
		if (head == null) {
			// if empty
			System.out.println("empty cant reverse");
			return head;
		}
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			// swap the previous with the next
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	void print(Node head) {
		//print all elements
		if (head == null) {
			System.out.println("empty cant print");
		} else {
			Node current = head;
			System.out.println("List Items are : ");
			while (current != null) {
				if (current.getItem() != null)
					System.out.println(current.getItem().toString() + " ");
				current = current.getNext();
			}
		}

	}

	public void readFromInputFile(Node head) throws IOException {
		// Reads from the input file and add the valid lines to the types
		PCs pc;
		Printers printer;
		Laptops laptop;
		Scanners scanner;
		int counter = 0;

		String line;
		String[] words;

		File file = new File("input.txt");
		Scanner scan_file = new Scanner(file);

		while (scan_file.hasNext()) {

			line = scan_file.nextLine();
			boolean valid, isLineValid;
			words = line.split(",");

			if (words[0].trim().equalsIgnoreCase("PC")) {
				isLineValid = validityCheck(words); // Checks if valid

				if (!isLineValid) // Not valid skip the line and inform the user
					System.out.println("Not Valid line in file");
				else {
					pc = new PCs(words[1], Double.parseDouble(words[2]), words[3], words[4], words[5], words[6]);
					insert(head, pc);
				}
			}

			if (words[0].trim().equalsIgnoreCase("printer")) {
				isLineValid = validityCheck(words);

				if (!isLineValid)
					System.out.println("Not Valid line in file");
				else {
					printer = new Printers(words[1], Double.parseDouble(words[2]), Boolean.parseBoolean(words[3]),
							Boolean.parseBoolean(words[4]));
					insert(head, printer);
				}
			}

			if (words[0].trim().equalsIgnoreCase("scanner")) {
				isLineValid = validityCheck(words);

				if (!isLineValid)
					System.out.println("Not Valid line in file");
				else {
					scanner = new Scanners(words[1], Double.parseDouble(words[2]), Boolean.parseBoolean(words[3]),
							Boolean.parseBoolean(words[4]));
					insert(head, scanner);
				}
			}
			if (words[0].trim().equalsIgnoreCase("laptop")) {
				isLineValid = validityCheck(words); // Checks if valid

				if (!isLineValid) // Not valid skip the line and inform the user
					System.out.println("Not Valid line in file");
				else {
					laptop = new Laptops(words[1], Double.parseDouble(words[2]), words[3], words[4], words[5],
							words[6]);
					insert(head, laptop);
				}

			}
		}
	}

	private boolean validityCheck(String[] line) {
		/*
		 * Checks if the line extracted from the input file matches the required format
		 * when all the requirements are not met then the input line is not valid
		 */
		if ((line[0].trim().equalsIgnoreCase("PC")) && (line.length == 7)) {
			try {
				Double.parseDouble(line[2]);
			} catch (NumberFormatException e) {
				System.out.println("Not Valid PC");
				return false;
			}
			return true;
		}

		else if ((line[0].trim().equalsIgnoreCase("laptop")) && (line.length == 7)) {
			try {
				Double.parseDouble(line[2]);
			} catch (NumberFormatException e) {
				System.out.println("Not Valid Laptop");
				return false;
			}
			return true;
		} else if ((line[0].trim().equalsIgnoreCase("Printer")) && (line.length == 5)) {
			try {
				Double.parseDouble(line[2]);
			} catch (NumberFormatException e) {
				System.out.println("Not Valid Printer");
				return false;
			}
			return true;
		} else if ((line[0].trim().equalsIgnoreCase("scanner")) && (line.length == 5)) {

			try {
				Double.parseDouble(line[2]);
			} catch (NumberFormatException e) {
				System.out.println("Not Valid Scanner");
				return false;
			}
			return true;
		} else
			return false;

	}

	public static void main(String[] args) {

		Menu menu = new Menu();
		int counter = 0;
		int choice;
		Node head = new Node();
		LinkedList ll = new LinkedList(head);
		try {// Catch a exception from reading or writing to a file
			menu.readFromInputFile(head);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {

			menu.menu();
			menu.print(head);
			boolean menu_valid = true;
			while (menu_valid)
				try {

					Scanner scan = new Scanner(System.in);
					choice = scan.nextInt();
					menu_valid = false;

					switch (choice) {

					case 1:
						// the user chooses the type and enter the parameters
						System.out.println("enter 1 for PCs, 2 for Laptop, 3 for Printers, and 4 for Scanners ");
						Scanner scan_add = new Scanner(System.in);
						int item_type=scan_add.nextInt();
						Items item_to_add=null;
						if(item_type==1) {//if pc
							Scanner scan_char_add = new Scanner(System.in);
							System.out.println("enter Brand");
							String brand=scan_char_add.next();
							System.out.println("enter Price");
							scan_char_add = new Scanner(System.in);
							Double price=scan_char_add.nextDouble();
							System.out.println(" enter CPU_brand");
							scan_char_add = new Scanner(System.in);
							String cpubrand=scan_char_add.next();
							System.out.println(" enter CPU_speed");
							String cpuspeed=scan_char_add.next();
							System.out.println(" enter Hard_Disk_capacity");
							String Hard_Disk_capacity=scan_char_add.next();
							System.out.println(" enter RAM_capacity");
							String RAM_capacity=scan_char_add.next();
							
							item_to_add= new PCs(brand, price, cpubrand, cpuspeed, Hard_Disk_capacity, RAM_capacity);
						}
						if(item_type==2) {// if laptop
							Scanner scan_char_add = new Scanner(System.in);
							System.out.println("enter Brand");
							String brand=scan_char_add.next();
							System.out.println("enter Price");
							scan_char_add = new Scanner(System.in);
							Double price=scan_char_add.nextDouble();
							System.out.println(" enter CPU_brand");
							scan_char_add = new Scanner(System.in);
							String cpubrand=scan_char_add.next();
							System.out.println(" enter CPU_speed");
							String cpuspeed=scan_char_add.next();
							System.out.println(" enter Hard_Disk_capacity");
							String Hard_Disk_capacity=scan_char_add.next();
							System.out.println(" enter RAM_capacity");
							String RAM_capacity=scan_char_add.next();
							
							item_to_add= new Laptops(brand, price, cpubrand, cpuspeed, Hard_Disk_capacity, RAM_capacity);
						}
						if(item_type==3) {//if printer
							Scanner scan_char_add = new Scanner(System.in);
							System.out.println("enter Brand");
							String brand=scan_char_add.next();
							System.out.println("enter Price");
							scan_char_add = new Scanner(System.in);
							Double price=scan_char_add.nextDouble();
							System.out.println(" enter isColored as True or False");
							scan_char_add = new Scanner(System.in);
							Boolean isColored=scan_char_add.nextBoolean();
							System.out.println(" enter isInkjet as True or False");
							scan_char_add = new Scanner(System.in);
							Boolean isInkjet=scan_char_add.nextBoolean();
							
							item_to_add= new Printers(brand, price, isColored, isInkjet);
						}
						
						if(item_type==4) {//if scanner
							Scanner scan_char_add = new Scanner(System.in);
							System.out.println("enter Brand");
							String brand=scan_char_add.next();
							System.out.println("enter Price");
							scan_char_add = new Scanner(System.in);
							Double price=scan_char_add.nextDouble();
							System.out.println(" enter isColored as True or False");
							scan_char_add = new Scanner(System.in);
							Boolean isColored=scan_char_add.nextBoolean();
							System.out.println(" enter isMultiFeed as True or False");
							scan_char_add = new Scanner(System.in);
							Boolean isMultiFeed=scan_char_add.nextBoolean();
							
							item_to_add= new Scanners(brand, price, isColored, isMultiFeed);
						}
						
						menu.insert(head, item_to_add);
						
						
						break;

					case 2:
						// Deletes item
						// chooses type
						System.out.println("enter 1 for PCs, 2 for laptops, 3 for Printers, and 4 for Scanners ");
						Scanner scan_delete = new Scanner(System.in);
						int type=scan_delete.nextInt();
						Object[] obj=menu.getType(head,type);
						if(obj!=null) {
							menu.show_delete((Items[]) obj[0]);
							System.out.println("choose index to delete");
							Scanner scan_delete_index = new Scanner(System.in);
							int index= scan_delete_index.nextInt();
							int[] ind=(int[]) obj[1];
							head=menu.delete(head, ind[index]);
							ll.setHead(head);
						}
						
						break;

					case 3:
						// sort computers
						Computers[] c = menu.getComputers(head);
						sort(c);
						System.out.println("-----------------------------------------------------");
						System.out.println("After sorting");
						System.out.println("-----------------------------------------------------");
						show(c);
						break;

					case 4:
						// display assets
						menu.getAll(head);
						break;
					case 5:
						//reverse
						head = menu.reverse(head);
						ll.setHead(head);
						break;

					case 6:
						System.out.println("Exiting...");
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Please Enter again");

					}

				} catch (Exception e) {
					System.out.println("Error Choose Again" + e);

				}
		}
	}
}
