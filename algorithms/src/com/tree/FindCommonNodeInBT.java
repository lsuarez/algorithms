package com.tree;


import java.util.Arrays;
import java.util.HashMap;

public class FindCommonNodeInBT {
    private static HashMap<Integer,Integer> visitedNodes;

    private static void findInChildren(TreeNode root, int value){
        if(root == null || root.getChildren() == null){
            return;
        }
        for(TreeNode node: root.getChildren()){
            if(node.data == value){
                savingVisitedNode(root.data);// saving parent
            }else{
                findInChildren(node,value);
            }
        }

    }

    private static void savingVisitedNode(int node){
        if(visitedNodes.containsKey(node)){
            int total = visitedNodes.get(node);
            total++;
            visitedNodes.remove(node);
            visitedNodes.put(node, total);
        }else{
            visitedNodes.put(node, 1);
        }
    }

    public static int findCommonNode(TreeNode tn , int v1, int v2){
        visitedNodes= new HashMap<>();
        if(tn.data == v1 && tn.data == v2){
            return v1;
        }
        findInChildren(tn, v1);
        findInChildren(tn, v2);
        if(visitedNodes.isEmpty() ||
                (visitedNodes.entrySet().stream().reduce((first,second) -> second).get().getValue()<=1&& visitedNodes.size()==1)){
            return 0;
        }
        return visitedNodes.entrySet().stream().reduce((first,second) -> second).get().getKey();
    }

    public static void main(String args[]){
        TreeNode [] level2Left= new TreeNode[2];
        TreeNode [] level2Right= new TreeNode[1];
        level2Right[0]=new TreeNode(8);

        level2Left[0]= new TreeNode(3);
        level2Left[1]= new TreeNode(5);

        TreeNode [] level1= new TreeNode[2];
        level1[0]=new TreeNode(level2Left,4);
        level1[1]=new TreeNode(level2Right,8);
        TreeNode tn = new TreeNode(level1, 6);
        System.out.println(findCommonNode(tn, 3,5)); //4
        System.out.println(findCommonNode(tn, 8,5)); //6
        System.out.println(findCommonNode(tn, 6,6)); //6
        System.out.println(findCommonNode(tn, 12,60)); //0
        System.out.println(findCommonNode(tn, 12,8)); //0



    }
}
