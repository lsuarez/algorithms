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
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(3);
        list.append(2);
        //It is printing 3
        System.out.println(list.getFirstRepeatedNode(list));
    }
}
