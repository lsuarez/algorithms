package com.sort;

public class SortWithRecursion {
    private static int[] sort(int a[], int low, int high){


        if(low>=high || high> a.length+1 || low<0 )
            return a;
        int pivot = (high+low)/2;

        if(pivot-1>=0 && a[pivot-1]> a[pivot])
            a=makeSwitch(a, pivot-1, pivot);
        if(pivot+1<=a.length-1 && a[pivot] > a[pivot+1]  )
            a=makeSwitch(a, pivot, pivot+1);
        sort(a, pivot+1, high);
        sort(a, 0, pivot);
        sort(a, pivot+1, high);
        return a;
    }
    private static int[] makeSwitch(int a[], int index1, int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2]= temp;
        return a;
    }
    public static void print(int a[]){
        for(int value:a){
            System.out.print(value+" ");
        }
    }
    public static void main (String args[]){
        int a[]={5,1,8,3,4,7,9};
        a=sort(a, 0, a.length);
        print(a);
        //Output: 1 3 4 5 7 8 9

        System.out.println();
        int a1[]={9,4,2,7,6,12,3,90,1};
        a1=sort(a1, 0, a1.length);
        print(a1);
        //Output: 1 2 3 4 6 9 7 12 90

        System.out.println();
        int a2[]={11,10,9,8,7,6,5,4,3,2,1};
        a2=sort(a2, 0, a2.length);
        a2=sort(a2, 0, a2.length);
        print(a2);
        //Output: 1 2 3 4 6 9 7 12 90
    }
}
