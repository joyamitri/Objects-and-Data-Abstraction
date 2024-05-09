package BinaryTree;

public class BTNode {
    private int info;
    private BTNode left;
    private BTNode right;

    public BTNode(int i){
        info = i;
        left = null;
        right = null;
    }

    public int getInfo(){
        return info;
    }

    public void setInfo(int i){
        info = i;
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

    public boolean isLeaf(){
        return (right == null && left == null);
    }

    public BTNode getMostLeft()
	//returns the most left node of the tree/subtree
	{
		if (left.getLeft() == null)
			return left;
		else
			return left.getMostLeft();
	}
}
