package com.arrays;

public class PrintSpiralWay {

    private static void printColumn(int[][]a, int col, int row, int maxRow){
        while(row<=maxRow) {
            System.out.print(a[row][col]+" ,");
            row++;
        }
    }
    private static void printRowReverse(int[][]a, int row, int col , int colMin){
        while(col>=colMin) {
            System.out.print(a[row][col]+" ,");
            col--;
        }
    }
    private static void printColumnReverse(int[][]a, int row, int col, int rowMin){
        while(row>=rowMin) {
            System.out.print(a[row][col]+" ,");
            row--;
        }
    }
    private static void printRow(int[][]a, int row, int col, int maxCol){
        while(col<=maxCol) {
            System.out.print(a[row][col]+", ");
            col++;
        }
    }

    public static void printMatrix(int[][]a){
        int row=0, col=0, rowMax=a.length-1, colMax=a.length-1 , colMin=0 , rowMin=0 ;
        while(colMax>=colMin){

            printRow(a,rowMin,colMin, colMax);
            row++;
            printColumn(a,colMax,row, rowMax);
            colMax--;
            printRowReverse(a,rowMax,colMax, colMin);
            rowMin++;
            rowMax--;
            printColumnReverse(a,rowMax,colMin, rowMin);
            colMin++;
        }
    }

    public static void main(String[] args) {
        int matrix[][]=new int[4][4];
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;
        matrix[0][3]=4;

        matrix[1][0]=5;
        matrix[1][1]=6;
        matrix[1][2]=7;
        matrix[1][3]=8;

        matrix[2][0]=9;
        matrix[2][1]=10;
        matrix[2][2]=11;
        matrix[2][3]=12;

        matrix[3][0]=13;
        matrix[3][1]=14;
        matrix[3][2]=15;
        matrix[3][3]=16;

        printMatrix(matrix); //1, 2, 3, 4, 8 ,12 ,16 ,15 ,14 ,13 ,9 ,5 ,6, 7, 11 ,10 ,


        int matrix2[][]=new int[3][3];
        matrix2[0][0]=1;
        matrix2[0][1]=2;
        matrix2[0][2]=3;

        matrix2[1][0]=4;
        matrix2[1][1]=5;
        matrix2[1][2]=6;


        matrix2[2][0]=7;
        matrix2[2][1]=8;
        matrix2[2][2]=9;

        System.out.println();

        printMatrix(matrix2); //1, 2, 3, 6 ,9 ,8 ,7 ,4 ,5,
    }
}
