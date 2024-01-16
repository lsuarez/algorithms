package com.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrintLeavesByLevel {


    static int level = 0;
    static List<BinaryNode> nodes = new CopyOnWriteArrayList<>();

    private static void printChildren(BinaryNode node) {

        if (node.getLeft() != null) {
            System.out.print(node.getLeft().getData() + " ");
            nodes.add(node.getLeft());
        }
        if (node.getRight() != null) {
            System.out.print(node.getRight().getData() + " ");
            nodes.add(node.getRight());
        }

    }

    public static void printingWithoutRecursion(BinaryNode bn) {
        if (bn == null) {
            return;
        }
        System.out.println(bn.getData());

        int i = 0;
        printChildren(bn);
        for (BinaryNode n : nodes) {
            i = i + 2;
            double enter = Math.pow(2, i - 1);
            if (i == enter) {
                System.out.println();
            }
            printChildren(n);
        }

    }

    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5), 4), new BinaryNode(new BinaryNode(12), new BinaryNode(null, null, 9), 8), 11);
        printingWithoutRecursion(tn);
        /*
        11
    4   |  8
 3 | 5  |  12  | 9
 */
    }
}
