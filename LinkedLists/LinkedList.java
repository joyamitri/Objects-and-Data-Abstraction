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

    public boolean insert(int i, int k){
        // insert k at index i, returns false if i is an invalid index, true otherwise

        if(i < 0 || i > size()){
            return false;
        }
        else{
            Node n = new Node(k);
            if (i == 0) {
                n.setNext(header);
                header = n;
            }
            else{
                Node current = header;
                for(int j = 0; j < i - 1; j++){
                    current = current.getNext();
                }
                n.setNext(current.getNext());
                current.setNext(n);
            }
            return true;
        }
    }

    public boolean delete(int i){
        if(i < 0 || i > size() - 1){
            return false;
        }
        else{
            if(i == 0){
                header = header.getNext();
            }
            else{
                Node current = header;
                for (int j = 0; j < i - 1; j++) {
                    current = current.getNext();
                }
                current.setNext(current.getNext().getNext());
            }
            return true;
        }
    }
}
