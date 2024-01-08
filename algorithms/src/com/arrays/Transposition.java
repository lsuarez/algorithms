package com.arrays;

public class Transposition {

    public static void printArray(int [][] a){
        for(int col=0; col< a[0].length; col++){
            for(int row=0; row<a.length; row++){
                System.out.print(a[col][row] + " ");
            }
            System.out.println();
        }
    }
    public static int [][] transposition(int [][] a){
        System.out.println("****");
        for(int col=0; col< a[0].length; col++){
            for(int row=col; row<a.length; row++){
               int temp = a[col][row];
                a[col][row] = a[row][col];
                a[row][col] = temp;
            }
        }
        return a;
    }

    public static void main(String args[]){
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 1;
        array[0][2] = 1;

        array[1][0] = 2;
        array[1][1] = 2;
        array[1][2] = 2;

        array[2][0] = 3;
        array[2][1] = 3;
        array[2][2] = 3;
        printArray(array);
        array = transposition(array);
        printArray(array);

        /*
1 1 1
2 2 2
3 3 3
****
1 2 3
1 2 3
1 2 3
         */
    }
}
