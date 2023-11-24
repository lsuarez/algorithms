package com.linked.list;

import java.util.HashMap;
import java.util.Map;

class LinkedList {
    Node head;

    private int size =0;

    void append( int d) {
        Node newNode = new Node(d);
        if (size != 0) {
            newNode.next = this.head;
        }
        this.head = newNode;
        size++;
    }
    void appendAnExistingOne(Node node){
        if (size != 0) {
            node.next = this.head;
        }
        this.head = node;
        size++;
    }

    int getSize(){
        return this.size;
    }

}

