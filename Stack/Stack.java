package Stack;

public class Stack {
    private Node header;

    public Stack(){
        header = null;
    }

    public void setHeader(Node n){
        header = n;
    }

    public Node getHeader(){
        return header;
    }

    public boolean empty(){
        return (header == null);
    }

    public void push(int i){
        Node n = new Node(i);
        if(empty()){
            header = n;
        }
        else{
            n.setNext(header);
            header = n;
        }
    }

    public int peek(){
        if(empty()){
            return -99;
        }
        else{
            return header.getInfo();
        }
    }

    public int pop(){
        if(empty()){
            return -99;
        }
        else{
            Node current = header;
            header = header.getNext();
            current.setNext(null);
            return current.getInfo();
        }
    }
}
