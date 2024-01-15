package com.tree;

import java.util.*;

public class FindLargestPath {

    private static ArrayList<Integer> path;
    static int counter = 0, root = 0,counterTemp = 0;
    static String pathLargest = "";




    public static ArrayList<Integer> longestPath(BinaryNode bn){
        if(bn ==null){
            ArrayList<Integer> output = new ArrayList<>();
            return output;
        }
        ArrayList<Integer> right = longestPath(bn.getRight());
        ArrayList<Integer> left = longestPath(bn.getLeft());

        if(right.size()<left.size()){
            left.add(bn.getData());
        }else{
            right.add(bn.getData());
        }
        return ( left.size()>right.size() ? left:right);

    }

    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(null, new BinaryNode(3), 9), new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1), 2), 7), 5);
     //   BinaryNode tn = new BinaryNode( new BinaryNode( new BinaryNode(3),null,4),null,2);
        System.out.println(longestPath(tn).toString());

  /*

        5
    9   |  7
   | 3  |  8  | 2
                  | 1
 */
    }
}
