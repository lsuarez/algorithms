package com.linked.list;

public class DeleteDuplicatedValues {

    public static Node removeDuplicatedValues(Node node){
        Node current = node;
        Node next = null;
        Node tmp= node;
        Node prev = node;
        while (current!=null){
            next = current.next;
            if(next == null || current.data!=next.data){
                prev = tmp;
                prev.next =current.next;
                tmp=prev.next;
            }
            current=current.next;
        }
        return node;
    }

    public static void main(String args[]){
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node2_2 = new Node(2);
        Node node3 = new Node(3);
        Node node3_1 = new Node(3);
        node3.next=node3_1;
        node2_2.next=node3;
        node2.next=node2_2;
        node.next=node2;
        removeDuplicatedValues(node);
    }
}
