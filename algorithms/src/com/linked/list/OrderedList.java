package com.linked.list;

public class OrderedList {

    public static Node orderingList(Node node){

        Node ordered = null;
        Node current=node;
        while(current !=null){
            Node bigger = null;
            Node temp=null;
            Node prev = node;
            int data=Integer.MIN_VALUE;
            while (current != null) {
                if (current.data > data) {
                    data = current.data;
                    bigger = current;
                    temp = prev;
                }
                prev = current;
                current = current.next;
            }
            if(temp!=bigger) {
                prev = temp;
                prev.next = bigger.next;
            }else{
                prev=bigger.next;
                node = prev;
            }

            temp = ordered;
            if(temp==null){
                temp = bigger;
                temp.next= null;
            }else {
                prev = temp;
                temp = bigger;
                temp.next = prev;
            }
            ordered = temp;
            current=node;
        }
        return ordered;
    }


    public static void printList(Node node){
        Node current = node;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    public static void main(String args[]){
        Node node = new Node(10); //10-> 8-> 11->7
        Node node2= new Node(8); // 7->8->10->11
        Node node3= new Node(11);
        Node node4= new Node(7);
        node3.next=node4;
        node2.next=node3;
        node.next= node2;

        printList(orderingList(node));

    }
}
