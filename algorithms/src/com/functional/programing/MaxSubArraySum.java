package com.functional.programing;


public class MaxSubArraySum {

    /**
     * BigO= n
     */
    public static int sum(int[] array){
        int[]results = new int[array.length];
        int previews = 0, res =0, index=1 ;
        if(array.length==1)
            return array[0];
        if(array.length>2){
            results[0] = array[0];
            previews = array[0];
        }
        for(int i=1; i<array.length; i++){
            if(previews>= array[i] ){
                res+=array[i];
                results[index]=res+previews;
                index++;
            }
            else{
                if(res==0)
                    results[index]=array[i];
                previews = array[i];
                index++;
                res=0;
            }
        }
        int result=Integer.MIN_VALUE;
        for(int n:results){
            if(n>result)
                result=n;
        }
        return result;
    }

    public static void main (String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sum(array)); //6
        int[] array2 ={5,-3,5};
        System.out.println(sum(array2)); //7
        int[] array3 ={1};
        System.out.println(sum(array3)); //1
    }
}
