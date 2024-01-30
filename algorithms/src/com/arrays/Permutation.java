package com.arrays;

import java.util.Arrays;
import java.util.List;

public class GetPermutations {

    private static List findPermutation(int[]a, int index){
        if(index< a.length && index+1<= a.length) {
            int temp = a[index];
            a[index]=a[index+1];
            a[index+1]=temp;
            return Arrays.asList(a);
        }
        return null;
    }
    public static List<List<Integer>> getPermutations(int[]a){
        if(a==null || a.length==0) {
            return null;
        }
        findPermutation(a, a[0]);
        return null;
    }
    public static void main(String args[]){
        System.out.println("Holaaaaaaaaaaa");

    }
    /*
     int[]array= new int[3];
        array[0]=1;
        array[1]=2;
        array[2]=3;
        System.out.println(array);
        List list =getPermutations(array);
        System.out.println(list.toString());
     */
}
