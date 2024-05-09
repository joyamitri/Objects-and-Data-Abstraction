Write a program that starts by displaying the following menu:

1.	Remove Duplicates
2.	Merge strings
3.	Reverse digits
4.	Contains letters
5.	Product of others
6.	Exit
- - - - - - - - - - - - - 
Enter a choice:


Choice 1 will invoke a recursive method that accepts a string s as a parameter and returns a string s’ with all consecutive duplicate characters in s removed (one remains). For example, if s=”aabbccded” then s’=”abcded”

Choice 2 will invoke a recursive method that accepts two strings s1 and s2 which contain words where the letters are alphabetically ordered (increasing order). The method returns a third string s3 with the letters in s1 and s2 merged in such a way that they are also sorted in s3. For example, if s1= “borx” and s2=”arst”, then s3=”aborrstx”.

Choice 3 will call the recursive method int reverseDigits(int n) which  returns the positive integer that you get when you reverse the digits of parameter  n. For example, when called with the parameter 12345, this method would return  54321. Do this with proper integer arithmetic instead of just simply converting to String, reversing that and then using  parseInt () to extract the result.

Choice 4 will call a recursive method that takes a string s and three char a, b, c as parameters and returns whether s contains these three letters in any order (not necessarily consecutively). 

Choice 5 will call a recursive method that takes an array of int and returns another array of int where every element is replaced with the product of the other elements .For example, if the array is 1,2,3, the method returns the array 6, 3, 2. If the array is 20, 5, 4, 6, 3, the method returns: 360, 360, 1800, 1200, 2400.

Choice 6 will terminate the program. 

Any other choice, will have the menu displayed again. 
