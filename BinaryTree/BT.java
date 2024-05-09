package BinaryTree;

public class BT {
    private BTNode root;

    public BT(){
        root = null;
    }

    public BTNode getRoot(){
        return root;
    }

    public void setRoot(BTNode r){
        root = r;
    }

    public int treeSize(BTNode root){
        if(root == null){
            return 0;
        }
        else{
            return 1 + treeSize(root.getRight()) + treeSize(root.getLeft());
        }
    }
}
