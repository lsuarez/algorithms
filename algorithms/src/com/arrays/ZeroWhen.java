package com.arrays;

public class ZeroWhen {

    public static void printArray(int[][] array){
        for(int i=0; i< array.length; i++){
            for(int j=0; j< array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public static void rotate(int[][]array){
        boolean[] row = new boolean[array.length];
        boolean[] col = new boolean[array[0].length];
        for(int i=0; i< array.length; i++){
            for(int j=0; j< array[0].length; j++){
                if(array[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0; i< row.length; i++){
            if(row[i])
                nullifyRow(array, i);
        }
        for(int i=0; i< col.length; i++){
            if(col[i])
                nullifyCol(array, i);
        }
        printArray(array);
    }
    private static void nullifyRow(int[][] array, int row){
        for(int j=0; j<array[0].length; j++){
            array[row][j]=0;
        }
    }
    private static void nullifyCol(int[][] array, int col){
        for(int i=0; i<array.length; i++){
            array[i][col]=0;
        }
    }
    public static void main(String[] args){
        int[][] array = new int[][]{{1,2,3},{8,0,3},{6,7,4},{5,5,9}};
        printArray(array);
        System.out.println(" ROTATE 90 degrees");
        rotate(array);
    }
}
