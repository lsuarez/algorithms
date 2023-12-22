package com.tree;

public class TreeNode {
    TreeNode[] children;
    int data;

    public TreeNode[] getChildren() {
        return children;
    }

    public void setChildren(TreeNode[] children) {
        this.children = children;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode(TreeNode[] children, int data) {
        this.children = children;
        this.data = data;
    }

    public TreeNode() {
    }
}
