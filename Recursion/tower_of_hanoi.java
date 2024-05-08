public class tower_of_hanoi {
    // Write Tower of Hanoi

    public void moveOneDisk(int start, int end){
        System.out.println("Move disk from: " + start + "to" + end);
    }

    public void moveTower(int n, int start, int end, int middle){
        if(n == 1){
            moveOneDisk(start, end);
        }
        else{
            moveTower(n - 1, start, middle, end);
            moveOneDisk(start, end);
            moveTower(n - 1, middle, end, start);
        }
    }
}