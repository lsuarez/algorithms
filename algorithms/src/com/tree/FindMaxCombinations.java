package com.tree;

import java.util.*;

public class FindMaxCombinations {


    private static Queue<Integer> getValues(int N){
        Queue<Integer> values = new LinkedList<>();
        for(int i=0; i<N; i++){
            values.add(i+1);
        }
        return values;
    }

    private static BinaryNode fill(BinaryNode node, int valToInsert){
        if(valToInsert < node.getData()){
            if(node.getLeft()!=null){
                return fill(node.getLeft(), valToInsert);
            }else{
                node.setLeft(new BinaryNode(valToInsert));
            }

            return node;
        }
        if(valToInsert > node.getData()){
            if(node.getRight()!=null){
                return fill(node.getRight(), valToInsert);
            }else {
                node.setRight(new BinaryNode(valToInsert));
            }
            return node;
        }
        return null;
    }

    public static List<BinaryNode> findMaxCombinations(int N) {

        List<BinaryNode> nodes = new ArrayList<>();
        Queue<Integer> values = getValues(N);

        int i=0;
        while(i<N){
            Queue<Integer> heads = getValues(N);

            BinaryNode root = new BinaryNode(values.poll());
            BinaryNode current = root;
            while (values.size() != 0) {

                current = fill(current, values.poll());

            }
            nodes.add(root);
            i++;
            values = heads;
            for(int j =0; j<i;j++){
                values.poll();
                values.add(j+1);
            }
        }
            return nodes;
    }


    public static void main(String[] args) {
        List<BinaryNode> nodes =findMaxCombinations(3);
        System.out.println(nodes.toString());
    }
    /*
        2
      1 |  3
    ********
      1
        2
          3
     *****
        3
      2
    1
    *******
    1
      3
    2
    *****
     3
   1
     2
     */
}
