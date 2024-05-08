public class binary_search {
    public boolean binarySearch(int[] a, int k, int first, int last){
        if((first == last) && (a[first] != k)){
            return false;
        }
    
        else{
            int m = (first + last) / 2;
            if(a[m] == k){
                return true;
            }
            else{
                if(k < a[m]){
                    last = m - 1;
                }
                else{
                    first = m + 1;
                }
                return binarySearch(a, k, first, last);
            }
        }
    }
}