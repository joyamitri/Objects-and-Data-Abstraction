package LinkedLists;

public class Node {
    private int info;
    private Node next;

    public Node(int i){
        info = i;
        next = null;
    }

    public void setInfo(int i){
        info = i;
    }

    public int getInfo(){
        return info;
    }

    public void setNext(Node n){
        next = n;
    }

    public Node getNext(){
        return next;
    }

}
