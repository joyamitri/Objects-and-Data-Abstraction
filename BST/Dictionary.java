package BST;

/*
_______________________________________________________________________________________________________________________

Program Description: Contains the main program of this assignment. Creating a dictionary that contains
   				 	 words and their meaning.
_______________________________________________________________________________________________________________________

*/

import java.io.*;
import java.util.Scanner;

public class Dictionary {
    private BST dictionary_tree;
	private String name_of_the_file; 
	
	public Dictionary()
	{
		dictionary_tree=null;
		name_of_the_file="";
	}
	
	public BST getTree()
	{
		return dictionary_tree;
	}
	
	public void setRoot(BST new_tree)
	{
		dictionary_tree=new_tree;
	}
	
	public void createDictionary()
	//asks the user to input the file name and creates a dictionary with saving all words and 
	//definition that exists in the file in a binary search tree (dictionary_tree)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String file_name=scan.nextLine();
		
		if (file_name.length()<4)
			file_name+=".txt";
		
		else if (!(file_name.substring(file_name.length()-4).equals(".txt")))
		{
			System.out.println("here");
			file_name+=".txt";
		}
		
		int count=0;
		while(count<3)
		{
		try
		{
		Scanner read_file=new Scanner(new File(file_name));
		count=100;
		name_of_the_file=file_name;
		read_file.useDelimiter("\n");
		
		String line=read_file.next();
		line=line.replace(" ", "");
		Scanner read_line=new Scanner(line);
		read_line.useDelimiter(":|\n");
		int check_error=0; String word=""; String definition="";
		addFromFile(line,1,read_file,read_line,check_error,word,definition);
		}catch(IOException e)
		{
			System.out.println("Error! File not found...\n");
			count++;
			if(count<3)
				{
				 System.out.println("Try again. Enter file name: ");
				 file_name=scan.nextLine();
				}
			if(count==3)
				System.out.println("You have exceeded the number of trials. Going back to menu...\n");
		}
		}
			
	}
	public void addFromFile(String line,int line_number,Scanner read_file,Scanner read_line,int check_error,String word,String definition)
	//adds from file the words and there definitions in dictionary_tree
	{
		if (read_line.hasNext())
		{
			check_error++;
			if (check_error==1)
			{
			word=read_line.next();
			}
			
			if (check_error==2)
			{
			definition=read_line.next();
			if(definition.indexOf(' ')==0)
				definition=definition.substring(1);
			if (read_file.hasNext())
				definition=definition.substring(0,definition.length()-1);
			}
			
			addFromFile(line,line_number,read_file,read_line,check_error,word,definition);
		}
		
		else
		{
		if (check_error<1 || check_error>2)
		{
			System.out.println("Error in line "+line_number+": more/less parameters than required! Skipping this line...\n");
		}
		else
		{
			BTNode add_word=new BTNode(word,definition);
			System.out.print("Line "+line_number+": ");
			if (dictionary_tree==null)
				dictionary_tree=new BST();
			dictionary_tree.add(add_word, dictionary_tree.getRoot());
		}
		}
			
		if(read_file.hasNext())
		{
			line=read_file.next();
			read_line=new Scanner(line);
			read_line.useDelimiter(":|\n");
			addFromFile(line,line_number+1,read_file,read_line,0,"","");
		}
		else
		{
			return;
		}
	}
	public void addDefinition()
	//adding a new word/hynomyms and definition by asking the user to input them
	{
		if(dictionary_tree==null)
		{
			System.out.println("Error! Dictionary is not created yet! Going back to menu...\n");
		}
		else
		{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter word: ");
		String word=scan.nextLine();
		
		System.out.println("Enter definition: ");
		String definition=scan.nextLine();
		
		BTNode new_word=new BTNode(word, definition);
		dictionary_tree.add(new_word,dictionary_tree.getRoot());
		}
	}
		
	public void deleteDefinition() throws NumberFormatException
	//deletes a desired word and its definition
	{
			if(dictionary_tree==null || dictionary_tree.getRoot()==null)
		{
			System.out.println("Error! Tree is emtpy...\n");
		}
		else
		{
		Scanner scan=new Scanner(System.in);
		System.out.println("Which word would you like to delete: ");
		String delete_word=scan.nextLine();
		BTNode delete=new BTNode(delete_word,"");
		int size=dictionary_tree.size(dictionary_tree.getRoot());
		if(dictionary_tree.existsWord(delete,dictionary_tree.getRoot()))
		{
		System.out.println("Which definition would you like to delete?\nEnter 99 if you would like to remove all the definitions\n");
		dictionary_tree.getHomonys(dictionary_tree.getRoot(), delete, 0);
		int number=Integer.parseInt(scan.nextLine());
		if(number>0)
		{
			if(number!=99)
			{
			dictionary_tree.remove(dictionary_tree.getRoot(),delete,1,number);
			if(size!=dictionary_tree.size(dictionary_tree.getRoot()))
			System.out.println("this definition is removed\n");
			else
				System.out.println("Error! Invalid number. Going to menu...\n");
			}
			else if(number==99)
			{
			while(dictionary_tree.existsWord(delete, dictionary_tree.getRoot()))
			{
				dictionary_tree.remove(dictionary_tree.getRoot(),delete,1,1);
			}
			System.out.println("All definitions of "+delete_word+" are removed.\n");
			}
		}
		}
		else
			System.out.println("Error! "+"\""+delete_word+"\" does not exist in the dictionary. Going back to menu...\n");
		}
			
		}
	public void searchDefinition()
	//searches for the definitions of a desired word
	{
		if(dictionary_tree==null)
		{
			System.out.println("Error! Dictionary is not created yet! Going back to menu...\n");
			return ;
		}
		else
		{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter word: ");
		String word=scan.nextLine();
		BTNode desired= new BTNode(word,"");
		System.out.println("Definitions found: ");
		dictionary_tree.search(desired,dictionary_tree.getRoot(),0);
		}
	}
		
	public void printDictionary()
	//prints all words and there meaning that exists in dictionary_tree
	{
		if(dictionary_tree==null) 
		{
			System.out.println("Error! Dictionary is empty. Going back to menu...\n");
			return;
		}
		else
		{
			dictionary_tree.print(dictionary_tree.getRoot());
		}
	}
		
	public void exitDictionary()
	//updates the file with modifications that were made in dictionary_tree
	{
		if(dictionary_tree==null) 
		{
			System.out.println("Dictionary is empty. Ni file was given\n");
		}
		else
		{
		System.out.println("Updating file...\n");
		FileWriter fw=null;
		PrintWriter pw=null;
		try
		{
		fw=new FileWriter(name_of_the_file);
		pw=new PrintWriter(fw);
		exit(pw,dictionary_tree.getRoot());
		pw.close();
		System.out.println("File was successfully updated!\n");
		}
		catch (IOException e)
		{
			System.out.println("Error!\nFile couldn't be created\nDisplaying main menu again...\n");
		}
		catch(NullPointerException e)
		{
			System.out.println("Error! Dictionary is empty.\n");
		}
		finally {
			pw.close();
		}
		}
	}
		
	public void exit(PrintWriter pw,BTNode bt)
	//prints in the file modifications that were made in dictionary_tree
	{
		if(dictionary_tree==null) 
		{
			pw.println("Dictionary is empty.\n");
			return;
		}
		else if (bt==null)
		{
			return;
		}
		else
		{
			exit(pw,bt.getLeft());
			pw.println(bt);
			exit(pw,bt.getRight());
		}
	}
	public int displayMenu()
	//returns the choice that the user desires to do in the program
	{
		int choice=-999;
		try
		{
		Scanner scan=new Scanner(System.in);
		System.out.println("1. Create the dictionary");
		System.out.println("2. Add a definition");
		System.out.println("3. Remove a definition");
		System.out.println("4. Search for a definition");
		System.out.println("5. Print dictionary");
		System.out.println("6. Exit");
		System.out.println("-----------------------------");
		System.out.println("Enter your choice:");
		choice=Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Error! Need a number between 1 and 6...\n");
		}
		return choice;
	}
	public static void main(String[] args) 
	//main method of the program
	{
		Dictionary p=new Dictionary();
		boolean run_program=true;
		do
		{
			int option=p.displayMenu();
			
				switch(option)
			{
				case 1:
				p.createDictionary();
				break;
					
				case 2:
				p.addDefinition();
				break;
				
				case 3:
				try{p.deleteDefinition();}
				catch(NumberFormatException e) 
				{
					System.out.println("Error! Need a number. Going back to menu...\n");
				}
				break;
				
				case 4:
				p.searchDefinition();
				System.out.println();
				break;
				
				case 5:
				p.printDictionary();
				System.out.println();
				break;
				
				case 6:
				p.exitDictionary();
				System.out.println("Shutting down program...\n");
				run_program=false;
				break;
				
				default:
				if (option!=-999)
				{
					System.out.println("Error! You only have 6 options 1, 2, 3, 4, 5 or 6...\n");
				}
				break;
			}
		}while(run_program);
	}
}
