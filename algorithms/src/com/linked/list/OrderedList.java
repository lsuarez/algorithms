package com.linked.list;

public class OrderedList {
    public static Node orderingList(Node node){
        Node tmp = null;
        Node current = node;
        Node next = null;
        Node prev = node;
        while(current != null){
            next = current.next;
            if(next!= null && next.data<current.data) {
                tmp = current;
                current = next;
                tmp.next = next.next;
                current.next = tmp;
            }
            current = next;
        }

        return node;
    }
    public static void main(String args[]){
        Node node = new Node(9);
        Node node2= new Node(7);
        Node node3= new Node(8);
        node2.next=node3;
        node.next= node2;
        // reverse(node);
        Node reverse = orderingList(node);
        System.out.println(reverse);

    }
}
