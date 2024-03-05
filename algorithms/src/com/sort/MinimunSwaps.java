package com.sort;

import java.util.Arrays;
import java.util.List;

public class MinimunSwaps {


    public static long countInversions(List<Integer> arr) {
        Integer[] array = arr.toArray(new Integer[arr.size()]);
        long swapCounter=0;

        int prevIndex=0;
        int min = arr.get(prevIndex);
        for(int i=1; i<array.length;i++){
            while(min>array[i]){

            }
        }
        return swapCounter;
    }

    public static void main(String[] args) {
        Integer [] arr= new Integer[] {7 ,5, 3, 1};
        List<Integer> list= Arrays.asList(arr); //6
        //  7, 1, 3, 2, 4, 5, 6->5
    //{3, 7 ,6 ,9 ,1 ,8, 10, 4, 2, 5}; // ->9
        //
        System.out.println(countInversions(list));
    }
}
