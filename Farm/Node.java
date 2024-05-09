package Farm;

public class Node {
    // Declaring the attributes of the class Node:
	private Animal info;
	private Node next;

	public Node(Animal a)
	// Initializes the characteristics of the class by assigning a to info and next
	// to null
	{
		info = a;
		next = null;
	}

	public Animal getInfo()
	// returns the info of the node
	{
		return info;
	}

	public void setInfo(Animal new_info)
	// changes info to new_info
	{
		info = new_info;
	}

	public Node getNext()
	// returns next of the animal
	{
		return next;
	}

	public void setNext(Node new_next)
	// changes next to new_next
	{
		next = new_next;
	}
}
