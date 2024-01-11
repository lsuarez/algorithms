package com.tree;

import java.util.HashMap;

public class FindMinimumCommonNode {

    private static HashMap<Integer, Node> visited = new HashMap<>();

    private static Node findParentNode(Node current,  int searchingValue){
        if(current == null || (current.right==null && current.left==null)){
            System.out.println("Value:"+ searchingValue +" is not in the tree");
            return null;
        }
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

    public static int findMinimumCommonNode(BinaryTree bt, int value1, int value2){
        int searchingValue=0;
        if(value1 == bt.root.value || value2 == bt.root.value){
            return bt.root.value;
        }

        Node parentNodeIzq = null;
        Node parentNodeLeft=null;


        parentNodeIzq = findParentNode(bt.root, value1);
        if(visited.containsKey(parentNodeIzq.value)){
            return parentNodeIzq.value;
        }
        visited.put(parentNodeIzq.value, parentNodeIzq);
        parentNodeLeft = findParentNode(bt.root, value2);
        if(visited.containsKey(parentNodeLeft.value)){
            return parentNodeLeft.value;
        }
        visited.put(parentNodeLeft.value, parentNodeLeft);

        if(parentNodeIzq == parentNodeLeft){
            return parentNodeIzq.value;
        }
        return findMinimumCommonNode(bt, parentNodeLeft.value, parentNodeIzq.value);
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(1);
        bt.add(9);


        System.out.println(findMinimumCommonNode(bt, 5, 1)); //4
    }
}
