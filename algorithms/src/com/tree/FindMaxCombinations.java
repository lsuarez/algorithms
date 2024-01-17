package com.tree;

import java.util.*;

public class FindMaxCombinations {


    private static int[] getValues(int N){
        int[] values = new int[N];
        for(int i=0; i<N; i++){
            values[i]=(i+1);
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

    public static Set<BinaryNode> findMaxCombinations(int N) {

        Set<BinaryNode> nodes = new HashSet<>();
        int[]values = getValues(N);
        List<int[]> permutations = permute(values);

        for(int[]nums: permutations){
            int i=0;
            BinaryNode root = new BinaryNode(nums[i]);
            i++;
            BinaryNode current = root;
            while (values.length-i > 0) {
                current = fill(current, nums[i]);
                i++;
            }
            nodes.add(root);
        }
            return nodes;
    }
    // Function for swapping two numbers
    static void swap(int nums[], int l, int i)
    {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }


    static void permutations(ArrayList<int[]> res,
                             int[] nums, int l, int h) {
        if (l == h) {
            res.add(Arrays.copyOf(nums, nums.length));
            return;
        }

        for (int i = l; i <= h; i++) {
            swap(nums, l, i);
            permutations(res, nums, l + 1, h);
            swap(nums, l, i);
        }
    }
    static ArrayList<int[]> permute(int[] nums)
    {
        ArrayList<int[]> res = new ArrayList<int[]>();
        int x = nums.length - 1;
        permutations(res, nums, 0, x);
        return res;
    }
    public static void main(String[] args) {
        Set<BinaryNode> nodes =findMaxCombinations(3);
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
