package com.tree;

public class PrintLeavesOfATree {

    public static void printLeaves(BinaryNode tn){
        if(tn==null){
            return;
        }
        if(tn.getLeft() == null && tn.getRight() == null){
            System.out.print(tn.getData()+" ");
            return;
        }
        printLeaves(tn.getRight());
        printLeaves(tn.getLeft());
    }
    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5),4) , new BinaryNode(new BinaryNode(12), new BinaryNode(null, null,9),8), 11);
        printLeaves(tn);
        /*
        11
    4   |  8
 3 | 5  |  12  | 9
 */
        System.out.println();
        BinaryNode tn2 =
                new BinaryNode(new BinaryNode(new BinaryNode(100), null,4) , new BinaryNode(new BinaryNode(12), null,8), 11);
        printLeaves(tn2);
             /*
        11
    4   |  8
 100 | null  |  12  | null
 */
    }
}
