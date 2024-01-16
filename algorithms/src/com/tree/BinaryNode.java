package com.tree;

public class BinaryNode {

    private BinaryNode left;
    private BinaryNode right;
    private int data;

    public BinaryNode(BinaryNode left, BinaryNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryNode(int data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNode() {
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
