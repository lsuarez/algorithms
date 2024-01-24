package com.tree;

import java.util.*;

public class FindMaxCombinations {


    static ArrayList<BinaryNode> constructTrees(int start, int end)
    {
        ArrayList<BinaryNode> list=new ArrayList<>();
        if (start > end)
        {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++)
        {
            ArrayList<BinaryNode> leftSubtree  = constructTrees(start, i - 1);
            ArrayList<BinaryNode> rightSubtree = constructTrees(i + 1, end);
            for (int j = 0; j < leftSubtree.size(); j++)
            {
                BinaryNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++)
                {
                    BinaryNode right = rightSubtree.get(k);
                    BinaryNode node = new BinaryNode(i);        // making value i as root
                    node.setLeft(left);              // connect left subtree
                    node.setRight(right);            // connect right subtree
                    list.add(node);                // add this tree to list
                }
            }
        }
        return list;
    }

    static void preorder(BinaryNode root) {
        if (root != null)
        {
            System.out.print(root.getData()+" ") ;
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }
    public static void main(String[] args) {
        ArrayList<BinaryNode> totalTreesFrom1toN = constructTrees(1, 3);
        /*  Printing preorder traversal of all constructed BSTs   */
        System.out.println("Preorder traversals of all constructed BSTs are ");
        for (int i = 0; i < totalTreesFrom1toN.size(); i++)
        {
            preorder(totalTreesFrom1toN.get(i));
            System.out.println();
        }
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
