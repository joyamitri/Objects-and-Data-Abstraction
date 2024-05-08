// Calculate recursively n!

public long fact (int n){
    if(n == 0){
        return 1;
    }
    else if(n == 1){
        return 1;
    }
    else{
        return(n * fact(n - 1));
    }
}

public static void main (String[] args){
    System.out.println(fact(3));
}