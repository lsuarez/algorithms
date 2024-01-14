package com.tree;

import java.util.*;

public class FindLargestPath {

    static StringBuilder  largestPath=new StringBuilder();
    static String pathTemp="";
    static int  counter=1, root =0, counterTemp=0;

    public static boolean searchingLargestPath(BinaryNode bt){
        if(bt == null){
            return true;
        }
        if(bt.getLeft()==null&& bt.getRight() ==null){
            largestPath.append(bt.getData()+"->");
        }

        boolean isLeave;
        if(bt.getLeft()!=null){
            isLeave=searchingLargestPath(bt.getLeft());
            if(isLeave){
                largestPath.append(bt.getData()+"->");
                counter++;
                if(root == bt.getData()){
                    if(counter>counterTemp){
                        counterTemp=counter;
                        pathTemp=largestPath.toString();
                    }
                    largestPath=new StringBuilder();
                    counter=1;
                }
            }
        }

        if(bt.getRight()!=null){
            isLeave=searchingLargestPath(bt.getRight());
            if(isLeave){
                largestPath.append(bt.getData()+"->");
                counter++;
                if(root == bt.getData()){
                    if(counter>counterTemp){
                        counterTemp=counter;
                        pathTemp=largestPath.toString();
                    }
                    counter=1;
                    largestPath=new StringBuilder();
                }
            }
        }
        return true;

    }

    public static void printLargestPath(BinaryNode bt){
        root = bt.getRight().getData();
        searchingLargestPath(bt.getLeft());
        largestPath=new StringBuilder();
        counter=1;
        searchingLargestPath(bt.getRight());
        System.out.println("Largest path is:"+ pathTemp+bt.getData());

    }

    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(null, new BinaryNode(3),9) , new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1),2),7), 5);

        printLargestPath(tn);

  /*

        5
    9   |  7
   | 3  |  8  | 2
                  | 1
 */
    }
}
