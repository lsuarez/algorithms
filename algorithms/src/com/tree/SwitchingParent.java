package com.tree;

public class SwitchingParent {

    private static boolean findValue(BinaryNode root, int value){
        if(root == null) {
            return false;
        }
        if(root.getData() == value){
            return true;
        }
        boolean isFounded = findValue(root.getLeft(), value);
        if(isFounded){
            int parent = root.getData();
            root.setData(value);
            root.getLeft().setData(parent);
            return false;
        }
        isFounded = findValue(root.getRight(), value);
        if(isFounded){
            int parent = root.getData();
            root.setData(value);
            root.getRight().setData(parent);
            return false;
        }
        return false;
    }
    public static BinaryNode switchParent(BinaryNode root, int value){
       BinaryNode[] memory = new BinaryNode[1];
       memory[0]= root;
       findValue(root, value);
       return memory[0];
    }

    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5), 4), new BinaryNode(null, new BinaryNode(new BinaryNode(12), new BinaryNode(2), 9), 8), 6);
        switchParent(tn, 8);
    }
}

  /*

        6
    4   |  8
 3 | 5  |  12  | 9
                  | 2
*/
