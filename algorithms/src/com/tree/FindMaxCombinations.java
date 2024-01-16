package com.tree;

public class FindMaxCombinations {


    private static BinaryNode setNode(BinaryNode n1, BinaryNode n2, BinaryNode n3){
        BinaryNode node = new BinaryNode();
        node = n2;
        node.setLeft(n3);
        node.setRight(n1);
        return node;
    }

    public static BinaryNode[] findMaxCombinations(int N){
        BinaryNode[] combinations = new BinaryNode[N];
        if(N<=1){
            combinations[0]=new BinaryNode(N);
            return combinations;
        }


        int i=0;
        while(i< N){
            BinaryNode node =setNode( , , );
        }
        }

        return combinations;
    }
    public static void main(String[] args) {
        findMaxCombinations(3);
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
