public class sum{
    // Write a function that calculates the sum from 1 to n recursively 

    public static int summ(int n){
        if(n == 1){
            return 1;
        }
        else{
            return (n + summ(n - 1));
        }
    }

    public static void main (String[] args){
        System.out.println(summ(5));
    }
}