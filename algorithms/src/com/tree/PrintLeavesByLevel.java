package com.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

    public static void printLevelOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while(true){
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            while(nodeCount>0){
                BinaryNode node = q.peek();
                System.out.print(node.getData() + " ");
                q.remove();
                if(node.getLeft()!=null){
                    q.add(node.getLeft());
                }
                if(node.getRight()!=null){
                    q.add(node.getRight());
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5), 4), new BinaryNode(new BinaryNode(12), new BinaryNode(null, null, 9), 8), 11);
        printLevelOrder(tn);
        /*
        11
    4   |  8
 3 | 5  |  12  | 9
 */
    }
}
