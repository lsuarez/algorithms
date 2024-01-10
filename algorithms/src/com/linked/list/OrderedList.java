package com.linked.list;

public class OrderedList {
    public static Node ordering(Node node){
            Node tmp = null;
            Node current = node;
            Node next = null;
            Node prev = node;
            boolean firstSkipe = false;
            while(current != null){

                next = current.next;
                if(next!= null && next.data<current.data) {
                    tmp = current;
                    current = next;
                    tmp.next = next.next;
                    current.next = tmp;
                    if (node == tmp) {
                        node = current;
                    }else{
                        prev.next=current;
                    }
                    prev = current;

                }else{
                    if(firstSkipe){
                        prev = prev.next;
                        firstSkipe=false;
                    }
                    firstSkipe=true;
                }

                current = next;

            }
            return node;
    }
    public static Node orderList(Node node){
        Node current = node;
        while(current!=null){
            node =ordering(node);
            current = current.next;
        }
        return node;
    }

    public static void main(String args[]){
        Node node = new Node(10);
        Node node2= new Node(8);
        Node node3= new Node(11);
        Node node4= new Node(7);
        node3.next=node4;
        node2.next=node3;
        node.next= node2;
        Node ordered = orderList(node);
        System.out.println(ordered);

    }
}
