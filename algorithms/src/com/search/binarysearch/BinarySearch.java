package com.search.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int value, int[]array){
        if(array.length ==0)
            return -1;
        Arrays.sort(array);
        int low =0, high= array.length-1, mid =0;
        while(low<high){
            mid = low + (high-low)/2;
            if(value < array[mid])
                high = mid-1;
            else if(value > array[mid])
                low = mid+1;
            else if(value == array[mid])
                return mid;
        }
        return -1;//if nothing found

    }

    public static void main(String args[]){
        int[]array ={23,54,12,9,0,4};
        System.out.println(search(9, array));
        System.out.println(search(889, array));
    }
}
