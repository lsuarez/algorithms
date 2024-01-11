package com.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMinimumCommonNode {

    private static Deque<Integer> visited
            = new ArrayDeque<>();
    private static Node findParentNode(Node current,  int searchingValue){
        if(current == null || (current.right==null && current.left==null)){
            System.out.println("Value:"+ searchingValue +" is not in the tree");
            return null;
        }
        if(visited.contains(current.value)){
            return current;
        }
        visited.add(current.value);
        if(current.right!= null){
            if(current.right.value==searchingValue ){
                return current;
            }
            if(  current.value<searchingValue){
                return findParentNode(current.right, searchingValue);
            }

        }
        if(current.left!= null){
            if(current.left.value==searchingValue){
                return current;
            }
            if(  current.value>searchingValue) {
                return findParentNode(current.left, searchingValue);
            }
        }
        return null;

    }

    public static int findMinimumCommonNode(BST bt, int value1, int value2){
        int searchingValue=0;
        if(value1 == bt.root.value || value2 == bt.root.value){
            return bt.root.value;
        }
        Node parentNode1 = null;
        Node parentNode2=null;


        parentNode1 = findParentNode(bt.root, value1);
        if(visited.contains(parentNode1.value)){
            return visited.pollLast();
        }
        visited.add(parentNode1.value);
        parentNode2 = findParentNode(bt.root, value2);
        if(visited.contains(parentNode2.value)){
            return visited.pollLast();
        }
        visited.add(parentNode2.value);

        if(parentNode1 == parentNode2){
            return parentNode2.value;
        }
        return findMinimumCommonNode(bt, parentNode1.value, parentNode2.value);
    }

    public static void main(String[] args){
        BST bt = new BST();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(1);
        bt.add(9);


        System.out.println(findMinimumCommonNode(bt, 5, 1)); //4
        System.out.println(findMinimumCommonNode(bt, 9, 3)); //6
        System.out.println(findMinimumCommonNode(bt, 3, 5)); //4
        System.out.println(findMinimumCommonNode(bt, 12, 12)); //4
    }
}
