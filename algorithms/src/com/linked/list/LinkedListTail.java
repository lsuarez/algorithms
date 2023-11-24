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

    public int getIntersectedNode(){

        Node slow =this.head;
        Node fast = this.head;
        while(slow!=null && fast!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || slow == null)
            return -1;
        slow = this.head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

}
