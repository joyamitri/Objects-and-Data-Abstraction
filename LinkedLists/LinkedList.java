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

    public int size(){
        // returns # of nodes in the list

        if(header == null){
            return 0;
        }
        else{
            int count = 0;
            Node current = header;
            while (current.getNext() != null) {
                current = current.getNext();
                count ++;
            }

            return count;
        }
    }
}
