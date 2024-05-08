public class sequential_search {
    // Write a recursive method that performs sequential search on an array

    public boolean search(int[] a, int k, int i){
        // returns true if k is in a[], false otherwise
        // i is the index where search should start

        if((i > a.length - 1) || (i < 0)){
            return false;
        }
        else{
            if(a[i] == k){
                return true;
            }
            else if(i == a.length - 2 && a[i] != k){
                return false;
            }
            else{
                return search(a, k, i+1);
            }
        }
    }
}