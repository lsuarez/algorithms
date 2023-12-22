package com.recursion;

import java.util.List;

public class Recursion {

    //sum items in a list
    public static int sumItemsInAnArray(int [] list, int position){
        if(position> list.length-1)
            return 0;
        return list[position]+ sumItemsInAnArray(list, position+1);
    }

    //Find the maximum number in a list.
    public static int findMaximInAnArray(int [] array, int position, int max){
        if(position>array.length-1)
            return max;
        if(array[position]>max)
            max=array[position];
        return findMaximInAnArray(array,position+1,max);
    }
    //Find the minimum number in a list.
    public static int findMinimumInAnArray(int [] array, int position, int min){
        if(position>array.length-1)
            return min;
        if(array[position]<min)
            min=array[position];
        return findMinimumInAnArray(array,position+1,min);
    }
    public static void main(String[] args){
        int[]array = {1,9,23,-4};
        System.out.println("Sum:"+ sumItemsInAnArray(array,0));
        System.out.println("MAX:"+findMaximInAnArray(array,0,Integer.MIN_VALUE));
        System.out.println("MIN:"+findMinimumInAnArray(array,0,Integer.MAX_VALUE));
    }
}
