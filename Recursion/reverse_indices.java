public class reverse_indices{
    //  Write a method that reverses an array between 2 indices

    public static void reverse(int[] a, int s, int e){
        int temp = 0;

        if(s >= e){
            return;
        }

        temp = a[s];
        a[s] = a[e];
        a[e] = temp;

        reverse(a, s + 1, e - 1);
    }
}