package com.tree;

/**
 * A binary tree is a recursive data structure where each node can have 2 children at most.
 */
public class BinaryTree {
    Node root;
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }
    public static int sum(int[] array, int low, int high){
        if(low<0 || high> array.length)
            return 0;
        if(low >= high)
            return 0;
        if(low == high)
            return array[low];
        return array[low]+array[high]+sum(array,low+1, high-1);
    }
    public static void main(String[] args){
        int[] array ={1,2,3,4};
        System.out.println(sum(array, 0, array.length-1));
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(1);
        bt.add(9);



    }
}

class Node{
    int value;
    Node left;
    Node right;


    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
