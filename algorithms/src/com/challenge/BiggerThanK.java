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
            if(orderedDesc.size()==k){
                int temp = orderedDesc.poll();
                if(array[i]>temp){
                    orderedDesc.add(array[i]);
                }else{
                    orderedDesc.add(temp);
                }
            }else{
                orderedDesc.add(array[i]);
            }

        }
        int[] biggerNumbers= new int[k];
        Iterator<Integer>iterator = orderedDesc.iterator();
        for(int i=0; i<k;i++){
            if(iterator.hasNext()){
                biggerNumbers[i] =iterator.next();
            }
        }
        return biggerNumbers;
    }

    public static void main(String args[]){
        Integer [] array={2,43,1,54,90,56,33,88,14,16,13,85};
        System.out.println(searchBiggerNumbers(array, 4));  //-> 90, 88, 85, 56, 54,43,33
        System.out.println(searchBiggerNumbers(array, 0));
    }
}
