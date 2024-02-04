package com.challenge;

import java.util.*;

public class BiggerThanK {
    public static int[] searchBiggerNumbers(Integer array[], int k){
        int len = array.length;
        if(k> len)
            return null;
        if(k==0)
            return new int[0];
        PriorityQueue<Integer> orderedDesc= new PriorityQueue<>(k);
        for(int i=0; i<len;i++){
            orderedDesc.add(array[i]);
            if(orderedDesc.size()>k)
                orderedDesc.poll();

        }
        int[] biggerNumbers= new int[k];
        int i=k-1;
        while(!orderedDesc.isEmpty()){
                biggerNumbers[i] =orderedDesc.poll();
                i--;
        }
        for(int n:biggerNumbers){
            System.out.print(n+" ");
        }
        System.out.println();
        return biggerNumbers;
    }

    public static void main(String args[]){
        Integer [] array={2,43,1,54,90,56,33,88,14,16,13,85};
        searchBiggerNumbers(array, 4);  //-> 90, 88, 85, 56
        searchBiggerNumbers(array, 6);//90, 88, 85, 56, 54,43
    }
}
