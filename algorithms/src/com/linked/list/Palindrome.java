package com.linked.list;

public class Palindrome {

    public static boolean isPalindrome(LinkedList l1, LinkedList l2){
        Node l1Node = reverseList(l1.head);
        Node l2Node = l2.head;
        while(l1Node !=null && l2Node !=null){
            if(l1Node.data != l2Node.data)
                return false;
            l1Node = l1Node.next;
            l2Node = l2Node.next;
        }
        return true;
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
        l1.append(2);
        l1.append(29);
        l1.append(7);
        l1.append(8);
        LinkedList l2 = new LinkedList();
        l2.append(8);
        l2.append(7);
        l2.append(29);
        l2.append(2);

        //Success scenario
        System.out.println(isPalindrome(l1, l2));
    }
}
