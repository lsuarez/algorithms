package com.challenge;

public class MergeArrays {

    /*
    You have two sorted arrays you need to merge them with the result array still being sorted.
Create a function that receives two int arrays and returns one.
Eg: Array a: {1,4,5,100}    -> {1,2,4,5,5,6,100}
       Array b: {2,5,6}

public int[] merge(int[] arrayA, int[] arrayB) {
  //Your code:
}
     */

    public static int[] merge(int[]l ,int[]r){
        int[] result = new int[r.length+ l.length];
        int il=0, ir=0, index=0;
        while(ir<r.length&& il<l.length){
            if(r[ir]< l[il]){
                result[index] = r[ir];
                ir++;
            }else{
                result[index] = l[il];
                il++;
            }
            index++;
        }
        while(ir<r.length){
            result[index]=r[ir];
            ir++;
            index++;
        }
        while(il<l.length){
            result[index]=l[il];
            il++;
            index++;
        }
        return result;
    }
    /*
    Big o-> n+m
     */
    public static void main(String[] args) {
        /*
         Array a: {1,4,5,100}    -> {1,2,4,5,5,6,100}
       Array b: {2,5,6}
         */
        int[] l = new int[]{1,4,5,100};
        int[] r = new int[]{2,5,6};

        merge(l,r);
    }
}
