package com.linked.list;

public class OrderedList {

    private static Node removingANode(Node node, int toRemove){
        Node current = node;
        Node prev = node;
        Node temp=null;
        while(current!=null){
            if(current.data == toRemove){
                temp = current.next;
                if(prev == current){
                    return temp;
                }else {
                    prev.next = temp;
                }

                return node;
            }
            prev= current;
            current = current.next;
        }
        return node;
    }
    private static Node gatherBiggerOne(Node node){
        int data=Integer.MIN_VALUE;
        Node current = node;
        Node bigger = null;
        while(current !=null){
            if(current.data>data ){
                data = current.data;
                bigger = current;
            }
            current = current.next;
        }
        return bigger;
    }

    public static Node orderingList(Node node){
        Node current = node;
        Node prev = null;
        Node tmp = null;
        while(current!=null){
            tmp = prev;
            prev = gatherBiggerOne(node);
            node = removingANode(node, prev.data);
            current=current.next;
            if(tmp != null){
                prev.next = tmp;
            }else{
                prev.next= null;
            }
            if(current == null){
                tmp = prev;
                prev= node;
                prev.next = tmp;
            }
        }
        return prev;
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
