package Expression;

/*
_______________________________________________________________________________________________________________________

Program Description: This program's aim is to manage a stack

_______________________________________________________________________________________________________________________

*/

public class Stack {
    // implementation of stack using linkedlists
	
	private Node top;
	private int size;

	public Stack() {
		// constructor
		top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void push(String s) {
		// add to the top of the stack
		Node n = new Node(s);
		n.setNext(top);
		top = n;
		size++;
	}

	public String pop() {
		// remove the string from the top of the stack
		if (isEmpty() || top == null) {
			return "_";
		} else {
			Node temp = top;
			top = top.getNext();
			temp.setNext(null);
			size--;
			return temp.getData();
		}
	}

	public String peak() {
		// check the string in the top of the stack
		if (isEmpty() || top == null) {
			return "_";
		} else {
			return top.getData();
		}
	}
}
