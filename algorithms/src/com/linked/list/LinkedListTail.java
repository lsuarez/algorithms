package com.linked.list;

public class LinkedListTail {
    Node head;
    private int size =0;

    void append( int d) {
        Node newNode = new Node(d);
        if (size != 0) {
            newNode.next =this.head;
        }
        this.head = newNode;
        size++;
    }
    void appendAndExistingOne(Node node){
        this.head =insertInTail(this.head, node);
    }
    private Node insertInTail(Node head,Node n){
        if(head.next==null){
            head.next = n;
            return head;
        }
        head.next =insertInTail(head.next,n);
        return head;
    }

    int getSize(){
        return this.size;
    }

}
