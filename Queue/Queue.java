package Queue;

public class Queue {
    private Node header;

    public Queue(){
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

    public void enqueue(int i){
        // adds i to the queue
        Node n = new Node(i);
        n.setNext(header);
        header = n;
    }

    public int dequeue(){
        // dequeue element at the front of the queue & returns it
        if(empty()){
            return -99;
        }
        else{
            if(header.getNext() == null){
                Node to_return = header;
                header = null;
                return to_return.getInfo();
            }
            else{
                Node current = header;
                while (current.getNext().getNext() != null) {
                    current = current.getNext();
                }
                Node to_return = current.getNext();
                current.setNext(null);
                return to_return.getInfo();
            }
        }
    }
}
