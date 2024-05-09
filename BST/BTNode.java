package BST;

public class BTNode {
    private String word;
	private String explanation;
	private BTNode left,right;
	
	public BTNode(String w,String e)
	{
		word=w;
		explanation=e;
		left=null;
		right=null;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void setWord(String new_word)
	{
		word=new_word;
	}
	
	public String getExplanation()
	{
		return explanation;
	}
	
	public void setExplanation(String new_explanation)
	{
		explanation=new_explanation;
	}
	
	public BTNode getLeft()
	{
		return left;
	}
	
	public void setLeft(BTNode new_left)
	{
		left=new_left;
	}
	
	public BTNode getRight()
	{
		return right;
	}
	
	public void setRight(BTNode new_right)
	{
		right=new_right;
	}
	
	public BTNode getMostLeft()
	//returns the most left node of the tree/subtree
	{
		if (left.getLeft() == null)
			return left;
		else
			return left.getMostLeft();
	}
	
	public String toString()
	{
		return word+": "+explanation;
	}
}
