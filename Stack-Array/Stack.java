public class Stack {
    private int[] data;
    private int num_of_items;

    public Stack(int init_capacity){
        data = new int[init_capacity];
        num_of_items = 0;
    }

    public void push(int i){
        data[num_of_items] = i;
        num_of_items ++;
    }

    public int pop(){
        if (num_of_items == 0) {
            return -9999;
        }
        else{
            int j = data[num_of_items - 1];
            data[num_of_items] = -9999;
            num_of_items --;
            return j;
        }
    }

    public int peek(){
        if (num_of_items == 0) {
            return -9999;
        }
        else{
            return data[num_of_items - 1];
        }
    }
}
