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

    public ListNode sortList(ListNode head){
        ListNode[] initialHead = new ListNode[]{head};
        ListNode newHead = null;
        ListNode newTail = null;
        while(initialHead[0]!=null){
            ListNode smallestElement = smallestElement(initialHead);
            if(newHead==null){
                newHead= smallestElement;
            }else{
                newTail.next = smallestElement;
            }
            newTail = smallestElement;
        }
        return newHead;
    }
    public ListNode smallestElement(ListNode[] head){
        ListNode current = head[0];
        if(current==null){
            return null;
        }
        ListNode minimum = current;
        ListNode previousToMinimum = null;
        ListNode previos = null;
        while(current !=null){
            if(current.val<minimum.val){
                previousToMinimum = previos;
                minimum = current;
            }
            previos = current;
            current = current.next;
        }
        if(previousToMinimum!=null){
            previousToMinimum.next=minimum.next;
        }
        if(minimum==head[0]){
            head[0]= minimum.next;
        }
        minimum.next=null;
        return  minimum;
    }

    public static void main(String args[]){
        Node node = new Node(1); //10-> 8-> 11->7
        Node node2= new Node(2); // 7->8->10->11
        Node node3= new Node(3);
        Node node4= new Node(4);
        node3.next=node4;
        node2.next=node3;
        node.next= node2;
       // printList(orderingList(node));
       // printList(orderingList(node));
        ListNode n = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        OrderedList obj = new OrderedList();
        ListNode[] array = new ListNode[1];
        array[0]=n;
        obj.sortList(n);

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}