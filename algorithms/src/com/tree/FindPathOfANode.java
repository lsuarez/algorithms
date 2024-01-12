package com.tree;


import java.util.*;

public class FindPathOfANode {

    private static ArrayList<Integer> path;
    public static void searching(BinaryNode tn, int value1){
        path = new ArrayList();
        findPathOfNode(tn, value1);
        System.out.println(path.toString());
    }


    public static boolean findPathOfNode(BinaryNode parent,  int value1){
        if(parent ==null ){
            return false;
        }
        if(parent.getData() == value1 ){
            path.add(parent.getData());
            return true;
        }
        boolean isPath = findPathOfNode(parent.getLeft(), value1);
        if(isPath){
            path.add(parent.getData());
            return true;
        }
        isPath = findPathOfNode(parent.getRight(), value1);
        if(isPath){
            path.add(parent.getData());
            return true;
        }

        return false;
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
