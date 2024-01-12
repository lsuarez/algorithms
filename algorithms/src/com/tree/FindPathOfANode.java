package com.tree;


import java.util.*;

public class FindPathOfANode {

    private static ArrayList<Integer> path;
    public static void searching(BinaryNode tn, int value1){
        path = new ArrayList();
        path.add(findPathOfNode(tn, value1).getData());
        System.out.println(path.toString());
    }
    public static BinaryNode findPathOfNode(BinaryNode parent,  int value1){
        if(parent ==null ){
            return null;
        }
        if(parent.getData() == value1 ){
            return parent;
        }

        if(parent.getLeft()!=null) {
            if(parent.getLeft().getData() == value1  ){
                path.add(parent.getLeft().getData());
                return parent;
                }
                BinaryNode founded=null;
                founded = findPathOfNode(parent.getLeft(), value1);
                if(founded != null) {
                    path.add(founded.getData());
                    return parent;
                }
        }
        if(parent.getRight()!=null) {
            if (parent.getRight().getData() == value1) {
                path.add(parent.getRight().getData());
                return parent;
            }
            BinaryNode founded = null;
            founded = findPathOfNode(parent.getRight(), value1);
            if (founded != null) {
                path.add(founded.getData());
                return parent;
            }
        }

        return null;
    }

    public static void main(String[] args){
        BinaryNode tn =
                new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5),4) , new BinaryNode(null, new BinaryNode(new BinaryNode(12), new BinaryNode(2),9),8), 6);


        searching(tn, 3);//3-4 - 6
        searching(tn, 2); // 2-9 - 8 - 6
        searching(tn, 12); //12- 8 -6
        searching(tn, 5); //5-4-6


/*
        6
    4   |  8
 3 | 5  |  12  | 9
                  | 2
 */
    }
}
