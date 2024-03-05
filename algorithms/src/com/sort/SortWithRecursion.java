package com.sort;

import java.util.Arrays;
import java.util.Random;

public class SortWithRecursion {


    private static int[] sort(int[] a){
        if(a.length<=1)
            return a;
        int mid = a.length/2;
        int[] l= Arrays.copyOfRange(a,0, mid);
        int[] r= Arrays.copyOfRange(a, mid, a.length);

        return merge(sort(l), sort(r));
    }
    public static int[] merge(int[]l, int[]r){
        int ir=0, il=0, index=0;
        int [] result=new int[r.length+l.length];
        while(ir<r.length && il< l.length){
            if(r[ir]<l[il]){
                result[index]= r[ir];
                ir++;
            }else{
                result [index]= l[il];
                il++;
            }
            index++;
        }
        while(ir< r.length){
            result[index] = r[ir];
            index++;
            ir++;
        }
        while(il < l.length){
            result[index] = l[il];
            index++;
            il++;
        }
        return result;
    }




    public static void main (String[] args) {
        int[] a = new int[1_00];
        Random r = new Random();
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = r.nextInt(599);
        }
        System.out.println(Arrays.toString(a));
        a = sort(a);
        System.out.println(Arrays.toString(a));

    }
}
