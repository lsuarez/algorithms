package com.search;

public class BinarySearch {

    public static int getPositionOf(int num, int numbers[]) throws Exception{

        return findNumber(num, numbers, 0, numbers.length);
    }
    private static int findNumber(int num, int numbers[], int low, int high) throws Exception {
        int middle = (high-low)/2;
        middle = low + middle;
        if(low <0 || high>numbers.length || middle>=numbers.length)
            throw new Exception("Not Found");
        if(numbers[middle]== num)
            return middle;
        if(numbers[middle]>num)
            return findNumber(num, numbers, low, middle-1);
        if(numbers[middle]<num)
            return findNumber(num, numbers,middle+1, high);
        return 0;
    }

    public static void main(String args[])throws Exception{
        int[] numbers = {0,1,2,3,4,5,6,7,8,9,10};

        System.out.println(BinarySearch.getPositionOf(9, numbers));

    }
}
