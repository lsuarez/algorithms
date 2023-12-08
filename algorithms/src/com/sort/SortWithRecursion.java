package com.sort;

import java.util.Arrays;

public class SortWithRecursion {

    private static int[] sort(int a[], int low, int high){
        int mid = (high+low)/2;
        if(mid==0 )
            return Arrays.copyOfRange(a, low, mid);
        if(mid-1==high)
            return  Arrays.copyOfRange(a, mid+1, high);
        int left[]=sort(a, low, mid);
        int right[]=sort(a, (a.length-low)/2 +1, a.length);
        return merge(a,left , right);

    }
    private static int[] merge(int a[],int l[], int r[]){
        int ir=0, il=0, index=0;
        int ordered[]= new int[a.length];
        while(ir < r.length-1 && il< l.length-1){
            if(r[ir]<l[il]) {
                ordered[index] = r[ir];
                ir++;
            }
            else {
                ordered[index] = l[il];
                il++;
            }
            index++;
        }
        while(ir< r.length){
            ordered[index] = r[ir];
            ir++;
        }
        while(il < l.length){
            ordered[index] = l[il];
            il++;
        }
        return ordered;
    }


    public static void print(int a[]){
        for(int value:a){
            System.out.print(value+" ");
        }
    }
    public static void main (String args[]){
        int a[]={5,9,3,1,7,4,2};
        a=sort(a, 0, a.length);
        print(a);
        //Output: 1 3 4 5 7 8 9
/*
        System.out.println();
        int a1[]={9,4,2,7,6,12,3,90,1};
        a1=sort(a1, 0, a1.length);
        print(a1);
        //Output: 1 2 3 4 6 9 7 12 90

        System.out.println();
        int a2[]={11,10,9,8,7,6,5,4,3,2,1,7,4,23,34,12,75};
        a2=sort(a2, 0, a2.length);
        a2=sort(a2, 0, a2.length);
        print(a2);
        //Output: 1 2 3 4 5 6 7 8 9 10 11
        */
    }


}
