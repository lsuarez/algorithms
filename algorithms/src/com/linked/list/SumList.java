package com.linked.list;

public class SumList {
    public static void main(String args[]){
        Node l1 = new Node(7);
        l1.appendToTail(1);
        l1.appendToTail(6);
        Node l2 = new Node(5);
        l2.appendToTail(9);
        l2.appendToTail(2);

        Node result = sumList(l1, l2);
        System.out.println(result);

    }
    private static Node sumList(Node l1, Node l2){
        if(l1 == null && l2 == null ){
            return null;
        }
        Node result = new Node();
        boolean isHead = true;
        int carry=0;

        Node next1 = l1, next2 =l2;
        while(next1 != null || next2!=null){
            int value = carry;
            value += next1.data + next2.data;
            next1 = next1.next;
            next2 = next2.next;
            if(isHead) {
                result = new Node(value % 10);
                isHead= false;
            } else
                result.appendToTail(value%10);
            if(value>=10)
                carry=1;
            else
                carry =0;
        }
        return result;
    }

}

class Node{
    Node next =null;
    int data;
    public Node(int d){
        data =d;
    }
    public Node(){}
    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}
