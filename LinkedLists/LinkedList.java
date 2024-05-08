package LinkedLists;

public class LinkedList {
    private Node header;

    public LinkedList(){
        header = null;
    }

    public void add(int i){
        // adds i to the end of the list

        if(header == null){
            header = new Node(i);
        }
        else{
            Node current = header;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(i));
        }
    }
}
