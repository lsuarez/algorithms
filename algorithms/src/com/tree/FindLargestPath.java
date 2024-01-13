package com.tree;

import java.util.*;

public class FindLargestPath {
    public static ArrayList<Integer> paths= new ArrayList<>();
    public static ArrayList<String> array = new  ArrayList<>();
    static int root;
    public static boolean searchingLargestPath(BinaryNode bt){

        paths.add(bt.getData());

        if(bt.getLeft()!=null) {
            searchingLargestPath(bt.getLeft());
        }
        if(bt.getData()==root){
            paths= new ArrayList<>();
            paths.add(bt.getData());
        }
        if(bt.getRight()!=null) {
            searchingLargestPath(bt.getRight());
        }
        array.add(paths.toString());
        if(bt.getRight()==null && bt.getLeft()==null){
            paths.remove(paths.size()-1);
        }
        return false;
    }
    public static void printLargestPath(BinaryNode tn){
        root = tn.getData();
        searchingLargestPath(tn);
        String longestString = array
                .stream()
                .max(Comparator.comparingInt(String::length))
                .get();
        System.out.println("\nLargest path is = "
                + longestString);

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
