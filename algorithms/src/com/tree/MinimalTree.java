package com.tree;

import java.util.Arrays;

/**
 * Given a shorted (increasing order) array with unique integer elements, write an algorithm to create a binary
 * search tree with minimal height
 */
public class MinimalTree {

    private static NodeBTS createMinimalBTSRecursive(int array[], int low, int high){
        if(high<low)
            return null;
        int mid = (low+high)/2;
        NodeBTS root = new NodeBTS(array[mid]);
        root.left= createMinimalBTSRecursive(array, low, mid-1);
        root.right=createMinimalBTSRecursive(array, mid+1, high);
        return root;
    }

    public static NodeBTS createMinimalBTS(int array[]){
        Arrays.sort(array);

        return createMinimalBTSRecursive(array, 0, array.length-1);
    }
    public static void main(String args[]){
        int array[] = {1,3,5,9,2,11,76,34,90,8};
        NodeBTS root = createMinimalBTS(array);
        System.out.println(root.toString());
    }
}

class NodeBTS{
    int value;
    NodeBTS left;
    NodeBTS right;


    public NodeBTS(int value) {
        this.value = value;
    }

    public NodeBTS() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeBTS getLeft() {
        return left;
    }

    public void setLeft(NodeBTS left) {
        this.left = left;
    }

    public NodeBTS getRight() {
        return right;
    }

    public void setRight(NodeBTS right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "NodeBTS{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
