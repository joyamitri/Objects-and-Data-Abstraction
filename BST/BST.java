package BST;

public class BST {
    private BTNode root;
	
	public BST()
	{
		root=null;
	}
	
	public BTNode getRoot()
	{
		return root;
	}
	
	public void setRoot(BTNode new_root)
	{
		root=new_root;
	}
	
	public boolean equals(BTNode bt,BTNode current)
	{
		return (bt.getWord().equals(current.getWord())) && (bt.getExplanation().equals(current.getExplanation()));
	}
	
	public boolean homonyms(BTNode bt,BTNode current)
	//returns true if the 2 nodes have the same word, otherwise false
	{
		return (bt.getWord().equals(current.getWord())) && (!(bt.getExplanation().equals(current.getExplanation())));
	}
	
	public String compareWord(BTNode bt,BTNode current)
	//compares the String word of 2 nodes by checking the alphabetical order
	{
		String answer="";
		if (homonyms(bt,current))
		{
			answer="left";
		}
		else
		{
		String length="";
		
		if (bt.getWord().length() > current.getWord().length())
			length+=current.getWord().length();
		else
			length+=bt.getWord().length();
		
		String current_word=current.getWord().toLowerCase();
		String bt_word=bt.getWord().toLowerCase();
		
		for(int i=0;i<Integer.parseInt(length);i++)
		{
			if(bt.getWord().charAt(i)<current.getWord().charAt(i))
				{
				  answer="left";
				  break;
				}
			else if(bt.getWord().charAt(i)>current.getWord().charAt(i))
				{
				  answer="right";
				  break;
				}
		}
		
		if(answer.equals(""))
		{
			if (current.getWord().length() > bt.getWord().length())
				answer="left";
			else
				answer="right";
		}
		}
		return answer;
		
	}
	
	public void add(BTNode bt,BTNode current)
	//adds a new node to the tree
	{
		if (root==null)
		{
			root=bt;
			System.out.println(bt.getWord()+" added!");
		}
		else
		{
		boolean homonyms=false;
		if(exist(bt,current) || compareWord(bt,current).equals("equal"))
		{
			System.out.println("\""+bt.getWord()+"\" already exists in this tree!\n");
			return;
		}
		
		if(homonyms(bt,current)) 
		{
			homonyms=true;
		}
		
		if(current.getLeft()==null && compareWord(bt,current).equals("left"))
		{
			current.setLeft(bt);
			if(!homonyms)
				System.out.println(bt.getWord()+" added!\n");
			else
				System.out.println(bt.getWord()+" hymonyms added!\n");
			return;
		}
		if(current.getRight()==null && compareWord(bt,current).equals("right"))
		{
			current.setRight(bt);
			if(!homonyms)
				System.out.println(bt.getWord()+" added!\n");
			else
				System.out.println(bt.getWord()+" hymonyms added!\n");
			return;
		}
		if(compareWord(bt,current).equals("left"))
		{
			add(bt,current.getLeft());
		}
		else if(compareWord(bt,current).equals("right"))
		{
			add(bt,current.getRight());
		}
		}
	}
	
	public void remove(BTNode root, BTNode current, int i, int index) 
	//removes a given node from the tree
	{
		if (root == null) 
		{
		 return;
		}
		if (homonyms(root, current) && index==1) 
		{
			removeRoot(root);
			return;
		}
		else 
		{	
			if (root.getLeft() != null && homonyms(root.getLeft(), current) && i == index) 
			{
			removeLeft(root);
			return;
			} 
			
			else if (root.getRight() != null && homonyms(root.getRight(), current) && i == index) 
			{
			removeRight(root);
			return;
			} 
			
			else if (root.getLeft() != null && homonyms(root.getLeft(), current) && i != index) 
			{
			root = root.getLeft();
			remove(root, current, i + 1, index);
			} 
			
			else if (root.getRight() != null && homonyms(root.getRight(), current) && i != index) 
			{
			root = root.getRight();
			remove(root, current, i + 1, index);
			} 
			
			else if (homonyms(root,current))
				{
				 remove(root.getLeft(), current, i + 1, index);
				}
			
			else if (compareWord(current, root).equals("right"))
				{
				 remove(root.getRight(), current, i, index);
				}
			
			else
				{
				 remove(root.getLeft(), current, i, index);
				}
		}
	}

	public void removeLeft(BTNode root)
	//removes the left node of the current node from the tree
	{
	if (root.getLeft().getLeft() == null && root.getLeft().getRight() == null)
		root.setLeft(null);
	
	else if (root.getLeft().getRight() == null) 
	{
		BTNode remove_word = root.getLeft();
		root.setLeft(root.getLeft().getLeft());
		remove_word.setLeft(null);
	} 
	
	else if (root.getLeft().getLeft() == null) 
	{
		BTNode remove_word = root.getLeft();
		root.setLeft(root.getLeft().getRight());
		remove_word.setRight(null);
	} 
	
	else if (root.getLeft().getRight().getLeft() == null) 
	{
		BTNode moving = root.getLeft().getLeft();
		BTNode new_location = root.getLeft().getRight();
		new_location.setLeft(moving);
		BTNode remove = root.getLeft();
		root.setLeft(new_location);
		remove.setLeft(null);
		remove.setRight(null);
	} 
	
	else 
	{
		BTNode moving = root.getLeft().getLeft();
		BTNode new_location = root.getLeft().getRight().getMostLeft();
		BTNode remove = root.getLeft();
		root.setLeft(root.getLeft().getRight());
		new_location.setLeft(moving);
		remove.setLeft(null);
		remove.setRight(null);
	}

	}

	public void removeRight(BTNode root)
	//removes the right node of the current node from the tree
	{
		if (root.getRight().getRight() == null && root.getRight().getLeft() == null) 
		{
			root.setRight(null);
		}

		else if (root.getRight().getRight() == null) 
		{
			BTNode remove_word = root.getRight();
			root.setRight(root.getRight().getLeft());
			remove_word.setLeft(null);
		}

		else if (root.getRight().getLeft() == null) 
		{
			BTNode remove_word = root.getRight();
			root.setRight(root.getRight().getRight());
			remove_word.setRight(null);
		} 
		
		else if (root.getRight().getRight().getLeft() == null) 
		{
			BTNode remove_word = root.getRight();
			BTNode moving = root.getRight().getLeft();
			BTNode new_location = root.getRight().getRight();
			new_location.setLeft(moving);
			root.setRight(new_location);
			remove_word.setLeft(null);
			remove_word.setRight(null);
		} 
		
		else 
		{
			BTNode moving = root.getRight().getLeft();
			BTNode new_location = root.getRight().getRight().getMostLeft();
			BTNode remove_word = root.getRight();
			new_location.setLeft(moving);
			root.setRight(root.getRight().getRight());
			remove_word.setLeft(null);
			remove_word.setRight(null);
		}
	}

	public void removeRoot(BTNode root) 
	//removes the root from the tree
	{
		if (root.getLeft() == null && root.getRight() == null)
			root = null;
		
		else if (root.getRight() == null)
		{
			BTNode remove_word = root;
			root = root.getLeft();
			remove_word.setLeft(null);
		}
		
		else if (root.getLeft() == null)
			root = root.getRight();
		
		else if (root.getRight().getLeft() == null) 
		{
			BTNode moving = root.getLeft();
			BTNode new_location = root.getRight();
			new_location.setLeft(moving);
			BTNode remove_word = root;
			root = root.getRight();
			remove_word.setLeft(null);
			remove_word.setRight(null);
		} 
		
		else 
		{
			BTNode moving = root.getLeft();
			BTNode new_location = root.getRight().getMostLeft();
			BTNode remove_word = root;
			new_location.setLeft(moving);
			this.root = root.getRight();
			remove_word.setRight(null);
			remove_word.setLeft(null);
		}
	}
	
	public void search(BTNode desired,BTNode current, int count)
	//prints the different definitions that exists in the dictionary of a given desired word
	{
		if(root==null && count==0)
		{
			System.out.println("Error! Empty Tree, going back to main menu...\n");
			return;
		}
		if(current==null)
		{
			if(count ==0)
			{
			System.out.println("Error! Word was not found, going back to main menu...\n");
			return;
			}
			else
				return;
					
		}
		if(homonyms(desired,current))
		{
			count++;
			System.out.println(count+"-"+current.getExplanation());
			search(desired,current.getLeft(),count);
		}
		else if(compareWord(desired,current).equals("left"))
		{
			search(desired,current.getLeft(),count);
		}
		else if(compareWord(desired,current).equals("right"))
		{
			search(desired,current.getRight(),count);
		}
	}
	
	public void getHomonys(BTNode root, BTNode desired, int count) {
	//gets the definitions of a homonyms word
		if (root == null) 
		{
			return;
		} 
		else if (homonyms(root, desired)) 
		{
			count++;
			System.out.println(count+ "-" + root.getExplanation());
			getHomonys(root.getLeft(), desired, count);
		} 
		else if (compareWord(desired,root).equals("right"))
			
			getHomonys(root.getRight(), desired, count);
		
		else if (compareWord(desired,root).equals("left"))
			getHomonys(root.getLeft(), desired, count);
	}
	
	public boolean exist(BTNode desired, BTNode current)
	// returns true if the same word having the same definition already exists in the tree, false otherwise
	{
		if(root==null)
		{
			return false;
		}
		if(current==null || (current.getLeft()==null && current.getRight()==null))
		{
			return false;
		}
		
		else
		{
			exist(desired,current.getLeft());
			if(equals(desired,current)) return true;
			exist(desired,current.getRight());
			return false;
		}
	}
	
	public boolean existsWord(BTNode desired,BTNode current)
	//returns true if only the word already exists in the tree (not definition), false otherwise
	{
		if (root == null || current==null)
			return false;
		if (homonyms(desired,current))
			return true;
		if (compareWord(desired,current).equals("left"))
			return existsWord(desired,current.getLeft());
		else
			return existsWord(desired,current.getRight());

	}
	
	public void print(BTNode bt)
	//prints all nodes that exists in the tree
	{
		if(empty()) 
		{
			System.out.println("Error! Dictionary is empty. Going back to menu...\n");
			return;
		}
		else if (bt==null)
		{
			return;
		}
		else
		{
			print(bt.getLeft());
			System.out.println(bt);
			print(bt.getRight());
		}
	}
	
	public int size(BTNode bt)
	//returns the size of the tree
	{
		if(empty()) 
		{
			return 0;
		}
		else if (bt==null)
		{
			return 0;
		}
		else
		{
			return 1+size(bt.getRight())+size(bt.getLeft());
		}
	}

	public boolean empty()
	//returns true if the tree is empty, false otherwise
	{
		return root==null || (root.getLeft()==null && root.getRight()==null);
	}
}
