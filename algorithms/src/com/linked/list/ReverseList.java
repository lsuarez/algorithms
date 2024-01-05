package com.linked.list;

public class ReverseList {

    static Node head = null;
    static boolean first=true;
    public static Node reverse(Node node){
        while(node!= null) {
            if (head == null) {
                head = new Node(node.data);
            }else{
                Node tmp = new Node(node.data);
                tmp.next = head;
                head = tmp;
            }
            node = node.next;
        }
        return head;
    }

    public static Node reverseInSameList(Node node){
       Node tmp = null;
       Node current = node;
       Node next = null;
       while(current != null){
           next = current.next;
           current.next = tmp;
           tmp = current;
           current = next;
       }
       node = tmp;
       return node;
    }


    public static void main(String args[]){
        Node node = new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        node2.next=node3;
        node.next= node2;
       // reverse(node);
        Node reverse = reverseInSameList(node);
        System.out.println(reverse);

    }
}
