package com.tree;


import com.sun.source.tree.Tree;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class FindCommonNodeInBT {

    private static int howManyFounded =0;

    private static ArrayList path;
    public static void searching(TreeNode tn, int value1){
        howManyFounded =0;
        path = new ArrayList();
        path.add(findCommonNode(tn, value1));
        System.out.println(path.toString());
    }
    public static TreeNode findCommonNode(TreeNode parent,  int value1){
        if(parent ==null || howManyFounded>= 1){
            return null;
        }
        if(parent.data == value1 ){
            howManyFounded++;
            return parent;
        }

        if(parent.getChildren()!=null){
            if(parent.getChildren()[0]!=null) {
                if(parent.getChildren()[0].data == value1  ){
                    howManyFounded++;
                    return parent;
                }
                TreeNode founded=null;
                founded = findCommonNode(parent.getChildren()[0], value1);
                if(founded != null) {
                    path.add(founded);
                    return parent;
                }
            }
            if(parent.getChildren().length>1 && parent.getChildren()[1]!=null) {
                if(parent.getChildren()[1].data == value1  ){
                    howManyFounded++;
                    return parent;
                }
                TreeNode founded=null;
                founded = findCommonNode(parent.getChildren()[1], value1);
                if(founded != null){
                    path.add(founded);
                    return parent;
                }
            }
        }
        return null;
    }

    public static void main(String args[]){
        TreeNode [] level2Left= new TreeNode[2];
        TreeNode [] level2Right= new TreeNode[1];
        TreeNode [] level3Right= new TreeNode[2];
        TreeNode [] level4Right= new TreeNode[1];
        level4Right[0]= new TreeNode(2);
        level3Right[0]= new TreeNode(level4Right,9);
        level3Right[1]= new TreeNode(12);


        level2Left[0]= new TreeNode(3);
        level2Left[1]= new TreeNode(5);

        TreeNode [] level1= new TreeNode[2];
        level1[0]=new TreeNode(level2Left,4);
        level1[1]=new TreeNode(level3Right,8);
        TreeNode tn = new TreeNode(level1, 6);


        searching(tn, 3);//4 - 6
        searching(tn, 2); // 9 - 8 - 6
        searching(tn, 12); //8 -6
        //System.out.println(path.toString());
  //       System.out.println(findCommonNode(tn, 5,2)); //6


  //      System.out.println(findCommonNode(tn, 3,4)); //4
  //      System.out.println(findCommonNode(tn, 12,60)); //0
    //    System.out.println(findCommonNode(tn, 12,8)); //0



/*
        6
    4   |  8
 3 | 5  |  12  | 9
                  | 2
 */
    }
}
