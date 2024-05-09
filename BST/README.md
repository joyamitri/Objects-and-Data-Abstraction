You are asked to design and implement a binary search tree that simulates a dictionary. 
This tree is used to store definitions of words. Each definition has two parts, a word and  its description (explanation) both of which are strings.   The program starts by displaying the following menu:

1.	Create the dictionary
2.	Add a definition
3.	Remove a definition
4.	Search for a definition
5.	Print Dictionary
6.	Exit
-----------------------------------
Enter your choice:

Create the dictionary (recursive): The program prompts the user for the name of a text file where word definitions are stored.  Each word definition is stored on a line in the file. The definition has two parts, the word and its description separated with a colon ( : )
Following is an example of how the text file should look like:

Human Being: Evolved homosapien
Pen: Tool used to write 

The text file is then parsed and the definitions are extracted and stored in appropriate objects.  A binary search tree containing all the definitions is then constructed according to the order of appearance of the definitions in the text file. Definitions are compared by their word field hence, the word “animal” is smaller than the word “job”.  If the text file  is not found, the program should prompt for the name again. This is repeated three times, if after three times, the file with the specified name is still not found, the menu is displayed again.

Add a definition (recursive): This option allows the user to enter new definitions  in the tree. A definition(word+description)  can appear only once in the tree. The definitions are sorted alphabetically (by word).  Two definitions  are said to be  equal if they have the same word and  the same explanation. Two equal definitions cannot be in the tree at the same time. Two definitions are said to be homonyms if they have the same word but different explanations. Two homonyms are allowed  in the tree at the same time. 

Remember to maintain the binary search nature of the tree when you add new elements. 

Remove a definition: This option prompts the user for a word to remove. If one or more definitions of this word are found, they are all displayed and numbered. The user can either delete them all from the tree or specify which one to remove. If no definition of this word is found, an appropriate message is displayed. 

Remember to maintain the binary search nature of the tree when you add new elements. 

Search for a definition: This option allows the user to search for the definition of a word in the tree. All definitions of the input word are displayed on the screen. 

Remember to maintain the binary search nature of the tree when you add new elements. 

Print Dictionary: This prints all the definitions sorted lexicographically by word. 

Remember to take advantage of the binary search nature of the tree while doing the search. 

Exit – Terminates the program after saving all modifications to the text file.
