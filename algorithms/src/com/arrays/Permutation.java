package com.arrays;

import java.util.*;


public class Permutation {

    public  List<List<Integer>> getPermutations(int[]a){
        if(a==null || a.length==0) {
            return null;
        }
        int index =0;
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutation( index, a, permutations);

        return permutations;
    }

    private void findPermutation(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            result.add(list);
        } else {
            for (int j = i, l = nums.length; j < l; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                findPermutation(i + 1, nums, result);
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
    public static void main(String args[]){
        int[]array= new int[3];
        array[0]=1;
        array[1]=2;
        array[2]=3;

        Permutation obj = new Permutation();
        List list =obj.getPermutations(array);
        System.out.println(list.toString()); //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

    }

}
