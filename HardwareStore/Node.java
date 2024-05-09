package HardwareStore;

public class Node {
    protected Items item;
	protected Node node;

	public Node(Items item, Node node) {
		super();
		this.item = item;
		this.node = node;
	}

	public Node(Items item) {
		super();
		this.item = item;
		this.node = null;
	}

	public Node() {
		this.node = null;
		this.item=new Items("",0);
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}


	public Node getNext() {
		return node;
	}

	public void setNext(Node node) {
		this.node = node;
	}
}
