package com.linked.list;

import java.util.HashMap;

public class Intersection {
    static HashMap<Integer, Node> map = new HashMap<>();

    private static boolean areThereIntersected(LinkedListTail l1, LinkedListTail l2) {

        Node n1 = l1.head, n2=l2.head;
        Node newNode1, newNode2;
        while(n1.next !=null){
            saveNode(n1);
            n1 = n1.next;
        }
        while(n2.next!=null){
            newNode2 = saveNode(n2);
            if(newNode2 != null && ( newNode2 ==n2 ))
                return true;
            n2 = n2.next;
        }
        return false;
    }

    private static Node saveNode(Node n) {
        if(n == null)
            return null;
        if(map.containsKey(n.data))
            return map.get(n.data);
        else
            map.put(n.data, n);
        return null;
    }
    public static void main(String[] args){
        LinkedListTail l1 = new LinkedListTail();
        l1.append(3);
        l1.append(1);
        l1.append(5);
        l1.append(9);
        Node intersection = new Node(7);
        Node node2 = new Node(2);
        node2.next = new Node(1);
        intersection.next = node2;
        l1.appendAndExistingOne(intersection);

        LinkedListTail l2 = new LinkedListTail();
        l2.append(5);
        l2.append(6);
        l2.appendAndExistingOne(intersection);

        System.out.println(areThereIntersected(l1, l2));

    }
}
