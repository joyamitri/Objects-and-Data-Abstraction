package RecursionManipulation;

import java.util.Arrays;
import java.util.Scanner;

/*
_______________________________________________________________________________________________________________________

Program Description: This program's aims to manipulate strings and arrays using different recursive methods

_______________________________________________________________________________________________________________________

*/

public class Recursion {
    // 1. Remove Duplicates
	public static String removeDuplicate(String str) {
		return dupeHelper(str, "", "");
	}

	public static String dupeHelper(String str, String last, String ns) {
		//base case
		if (str.length() <= 1) {
			if (str.equals(last))
				return ns;
			return ns + str;
		}
//get one char
		String current = str.substring(0, 1);
//check if there are duplicates and remove duplicates
		if (current.equals(last)) {
			return ns + dupeHelper(str.substring(1), current, ns);//if there is duplicate
		}

		else {
			return ns + current + dupeHelper(str.substring(1), current, ns);// if no duplicate
		}

	}


	static String mergeString(String s1, String s2) {
		// base case
		if (s1 == "") {
			if (s2 == "")
				return "";
			return s2;
		} else if (s2 == "")
			return s1;
		//add the smallest to the beginning
		else if (s1.charAt(0) > s2.charAt(0))

			return s2.charAt(0) + mergeString(s1, s2.substring(1));
		return s1.charAt(0) + mergeString(s1.substring(1), s2);

	}


	public static int reverseInt(int a, int reverse) {

		if(a/10 == 0)// If a/10 is 0 then we reahced the end of the int
			return reverse + a%10;// we add the last digit and return it
		else {
			reverse = 10*(reverse + a%10);// go get the first digit of a we use % and each time we multiply it by 10 to make it on top 
			return reverseInt(a/10,reverse);// We call the method again
		}
	}

	public static void containsLetter(String s,char a, char b, char c) {

		if(("111").equalsIgnoreCase(""+a+b+c))// check if the characters are equal to the string 111
			System.out.println("The entered string does contain the entered chars");
		
		else if(s.length()==0)// if s<3 then it does not contains all the entered chars 
			System.out.println("The entered string does not contain the entered chars");
		
		else {
			
			s.toLowerCase();
			if(s.charAt(0) != a && s.charAt(0) != b && s.charAt(0) != c) {// if the frist index of the strign does not contain the chars we remove it
				s =s.substring(1);
				containsLetter(s,a,b,c);
			}
			else if(s.charAt(0) == a) {// If there is a character that matches the char entered then that char is transformed to 1
				s =s.substring(1);
				a = '1';
				containsLetter(s,a,b,c);// then we return the method with the changed char
			}
			else if(s.charAt(0) == b) {
				s =s.substring(1);
				b = '1';
				containsLetter(s,a,b,c);// similarly
			}
			else if(s.charAt(0)== c) {
				s =s.substring(1);
				c='1';
				containsLetter(s,a,b,c);// Final if the string contains all the char then the sum of the chars will become "111"
			}
		}
	}

	public static int[] productOthers(int[] arr,int[] arr2,int i,int j,int product) {

		if(i==arr2.length)// If it reaches length  this means all the array was scanned
			return arr2;
		else {
			if(j < arr.length) {// We will loop until j reaches arr.length
				if(i!=j) {
					product *=arr[j];// Product of all the element of arr except at index i
					arr2[i] = product;// we assign product to i at 0 first
					return productOthers(arr,arr2,i,j+1,product);// we increase j to have the product of all the element of the array arr
				}
				else
					return productOthers(arr,arr2,i,j+1,product);}// if we have i = j we skipp this index
			else
				return productOthers(arr,arr2,i+1,0,1);//When it is finished from i=0 we move to i=1 and reset j to 0 and product to 1 we continue to increase i in order to fill all arr2
		}	
	}



	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		int choice;
		while(true) {
			menu();
			choice = scan.nextInt();
			switch(choice) {
			
			case 1:	System.out.println("Please enter the string you want to remove the duplicates from");
					String s = scan.next();
					System.out.println(removeDuplicate(s));
					break;
			case 2: System.out.println("Enter the two string to merge");
					String s1 = scan.next();
					System.out.println("Second string: ");
					String s2 = scan.next();
					System.out.println(mergeString(s1,s2));
					break;
			case 3: System.out.println("Please enter a positive integer");
					int integer = scan.nextInt();
					System.out.println(reverseInt(integer,0));
					break;
			case 4: System.out.println("Enter the word you want to check");
					String word = scan.next();
					System.out.println("Enter the  3 chars");
					String first = scan.next();
					char a = first.charAt(0);
					String sec = scan.next();
					char b = sec.charAt(0);
					String third = scan.next();
					char c = third.charAt(0);
					containsLetter(word,a,b,c);
					break;
			case 5: System.out.println("Please enter the size of your array: ");
			 		int size = scan.nextInt();
			 		int[] arr = new int[size];
			 		int[] arr2 = new int[size];
			 		for(int i=0 ;i<size;i++) {
			 			System.out.println("Enter index " + i);
			 			arr[i] = scan.nextInt();
			 		}
			 		int[] output =productOthers(arr,arr2,0,0,1);
					System.out.println(Arrays.toString(output));
			 		break;
			
			case 6: System.exit(0);
			
			default:System.out.println("Please enter a value from the menu");
					break;

			}
			
		}

	}

	private static void menu() {
		System.out.println("1.Remove Duplicates\r\n"
					+ "2.Merge strings\r\n"
					+ "3.Reverse digits\r\n"
					+ "4.Contains letters\r\n"
					+ "5.Product of others\r\n"
					+ "6.Exit\r\n"
					+ "- - - - - - - - - - - - - \r\n"
					+ "Enter a choice:");
		
	}
}
