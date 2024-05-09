package Expression;

public class Node {
    // instance variables
	private String data;
	private Node next;

	public Node(String d) {
		// constructor set data to input string d and set next to null
		data = d;
		next = null;
	}

	// setters and getters
	public void setData(String d) {
		data = d;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Node getNext() {
		return next;
	}

	public String getData() {
		return data;
	}
}
