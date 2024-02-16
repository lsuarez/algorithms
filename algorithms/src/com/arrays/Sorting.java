package com.arrays;

import java.util.Arrays;
import java.util.List;

public class Sorting {
    public static int[] sort(List<Integer> list, int max){
        int [] a = new int[max+1];
        int [] order= new int[list.size()];
        for(int n:list){
            if(a[n]==0) {
                a[n] = 1;
            }else{
                a[n]=a[n]+1;
            }
        }
        int index=0;
        for(int i=0; i<a.length; i++){
            if(a[i]!=0) {
                int counter =0;
                while(counter< a[i]){
                    order[index] =i;
                    counter++;
                    index++;
                }
            }
        }

        for(int n:order){
            System.out.print(n+" ");
        }
        return order;
    }
    /*
    Big o -> n*m siendo m el valor mas alto
     */
    public static void main(String[] args) {
        List<Integer> list  = Arrays.asList(2,54,34,7,12,0,7);//0 2 7 7 12 34 54
        sort(list, 54);
    }
}
