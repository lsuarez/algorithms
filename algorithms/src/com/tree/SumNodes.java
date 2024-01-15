package com.tree;

public class SumNodes {

    public static int sum(BinaryNode node){
        if(node ==null){
            return 0;
        }
        return sum(node.getRight())+sum(node.getLeft()) +node.getData();

    }
    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5),4) , new BinaryNode(null, new BinaryNode(new BinaryNode(12), new BinaryNode(2),9),8), 6);
        System.out.println(sum(tn)); //49
        BinaryNode tn2 = new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5),4), null,1 );

        System.out.println(sum(tn2)); //13
        System.out.println(sum(null)); //0


  /*

        6
    4   |  8
 3 | 5  |  12  | 9
                  | 2
 */
    }
}
