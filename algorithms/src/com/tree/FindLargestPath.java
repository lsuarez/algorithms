package com.tree;

import java.util.*;

public class FindLargestPath {

    static StringBuilder largestPath = new StringBuilder();
    static String pathTemp = "";
    static int counter = 1, root = 0, counterTemp = 0;

    public static boolean searchingLargestPath(BinaryNode bt) {
        if (bt == null) {
            return true;
        }
        if (bt.getLeft() == null && bt.getRight() == null) {
            largestPath.append(bt.getData() + "->");
        }

        if (bt.getLeft() != null) {
            searchingLargestPath(bt.getLeft());
            largestPath.append(bt.getData() + "->");
            counter++;
            clean(bt.getData());
        }

        if (bt.getRight() != null) {
            searchingLargestPath(bt.getRight());
            largestPath.append(bt.getData() + "->");
            counter++;
            clean(bt.getData());

        }
        return true;

    }
    private static void clean(int current){
        if (root == current) {
            if (counter > counterTemp) {
                counterTemp = counter;
                pathTemp = largestPath.toString();
            }
            largestPath = new StringBuilder();
            counter = 1;
        }
    }

    public static void printLargestPath(BinaryNode bt) {
        root = bt.getRight().getData();
        searchingLargestPath(bt.getLeft());
        largestPath = new StringBuilder();
        counter = 1;
        searchingLargestPath(bt.getRight());
        System.out.println("Largest path is:" + pathTemp + bt.getData());

    }

    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(null, new BinaryNode(3), 9), new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1), 2), 7), 5);

        printLargestPath(tn);

  /*

        5
    9   |  7
   | 3  |  8  | 2
                  | 1
 */
    }
}
