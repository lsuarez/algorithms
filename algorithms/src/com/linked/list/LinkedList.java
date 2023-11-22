package com.linked.list;

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
    int getByPosition(int pos){
        int value =-1;
        if(pos>size)
            return value;
        Node current = this.head;
        Node temp = null;
        return 0;
    }


    int getSize(){
        return this.size;
    }

}

