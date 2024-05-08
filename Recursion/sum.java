// Write a function that calculates the sum from 1 to n recursively 

public int sum (int n){
    if(n == 1){
        return 1;
    }
    else{
        return (n + sum(n - 1));
    }
}

public static void main (String[] args){
    System.out.println(sum(5));
}