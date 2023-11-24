package com.linked.list;

/**
 * Given a list which might contain a loop, implement an algorithm that return the node at the
 * beginning of the loop(if one exists).
 * Input: 1-2-3-4-5-3
 * Output: 3
 *
 */
public class LoopDetection {
    public static void main(String args[]){
        LinkedListTail list = new LinkedListTail();
        // 1->2->3->4->2
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.append(1);
        list.appendAndExistingOne(node2);
        list.appendAndExistingOne(node3);
        list.appendAndExistingOne(node4);
        list.appendAndExistingOne(node2);

        //It is printing 2
        System.out.println(list.getIntersectedNode());
    }
}
