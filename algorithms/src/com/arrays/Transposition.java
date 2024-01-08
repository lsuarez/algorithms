package com.arrays;

public class Transposition {

    public static void printArray(int [][] a){
        for(int col=0; col< a.length; col++){
            for(int row=0; row<a[0].length ; row++){
                System.out.print(a[col][row] + " ");
            }
            System.out.println();
        }
    }

    public static void transposition(int [][] a){
        System.out.println("transposition");
        for(int col=0; col< a[0].length; col++){

            int r=0;
            while(r<= a[0].length){
                System.out.print(a[r][col] +" ");
                r++;
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int[][] array = new int[3][2];
        array[0][0] = 1;
        array[0][1] = 2;
       // array[0][2] = 1;

        array[1][0] = 3;
        array[1][1] = 4;
       // array[1][2] = 2;

        array[2][0] = 5;
        array[2][1] = 6;
       // array[2][2] = 3;
        printArray(array);
        transposition(array);
      //  printArray(array);

        /*
3 4
5 6
transposition
1 3 5
2 4 6

         */
    }
}
