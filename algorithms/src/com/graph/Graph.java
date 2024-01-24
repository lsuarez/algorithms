package com.graph;

public class Graph {
    private Node[] nodes;

    public Graph(Node[] nodes) {
        this.nodes = nodes;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }
}
class Node{
    private String node;
    private Node[] children;

    private String state;

    public Node(String node, Node[] children) {
        this.node = node;
        this.children = children;
    }

    public Node(String node) {
        this.node = node;
    }

    public Node(String node, String state) {
        this.node = node;
        this.state = state;
    }

    public Node(String node, Node[] children, String state) {
        this.node = node;
        this.children = children;
        this.state = state;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

