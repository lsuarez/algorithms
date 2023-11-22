package com.linked.list;

public class Palindrome {

    public static boolean isPalindrome(LinkedList l1){
        Node l2Node = l1.head;
        Node l1Node = reverseList(l1.head);

        while(l1Node !=null && l2Node !=null){
            if(l1Node.data != l2Node.data)
                return false;
            l1Node = l1Node.next;
            l2Node = l2Node.next;
        }

        return l1Node == null && l2Node ==null;
    }
    private static Node reverseList(Node node){

        Node head = null;
        while(node!= null){
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }
    public static void main(String args[]){
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(0);
        l1.append(3);
        l1.append(1);


        //Success scenario
        System.out.println(isPalindrome(l1));
    }
}
