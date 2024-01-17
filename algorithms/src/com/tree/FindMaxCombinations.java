package com.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMaxCombinations {


    private static BinaryNode setNode(BinaryNode n1, BinaryNode n2, BinaryNode n3) {
        BinaryNode n= n2;
        n.setRight(n3);
        n.setLeft(n1);
        return n;
    }

    public static List<BinaryNode> findMaxCombinations(BinaryNode n1, BinaryNode n2, BinaryNode n3) {

        List<BinaryNode> nodes = new ArrayList<>();


        BinaryNode node1 = setNode(n1, n2, n3);
        if (node1 != null) {
            nodes.add(node1);
        }
        BinaryNode node2 = n1;
        BinaryNode node2_3 = setNode(null, n2, n3);
        node2.setRight(node2_3);
        if (node2 != null) {
            nodes.add(node2);
        }
        BinaryNode node3 = n3;
        node3.setLeft(setNode(n1, n2, null));
        if (node3 != null) {
            nodes.add(node3);
        }
        BinaryNode node4 = n1;
        node4.setRight(setNode(n2, n3, null));
        if (node4 != null) {
            nodes.add(node4);
        }
        BinaryNode node5 = n3;
        node5.setLeft(setNode(null, n1, n2));
        if (node5 != null) {
            nodes.add(node5);
        }
        return nodes;
    }


    public static void main(String[] args) {
        findMaxCombinations(new BinaryNode(1), new BinaryNode(2), new BinaryNode(3));
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
