package com.challenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int counter =1, prev=a.get(0), prevCounter=0;
        for(int i=1; i<a.size();i++){
            int current = a.get(i);
            if(prev == current || prev-1 == current || prev == current-1){
                counter++;
            }else{
                if(counter> prevCounter){
                    prevCounter= counter;
                }
                prev = a.get((i-counter)+1);
                i=(i-counter)+1;
                counter=1;
            }
        }
        return prevCounter==0?counter:prevCounter;
    }

    public static void main(String[] args) {
        /*
        84 43 11 41 2 99 31 32 56 53 42 14 98 27 64 57 16 33 48 21 46 61 87 90 28 12 62 49 29 77 82 70 80 89 95 52 13 19 9 79 35 67 51 39 7 1 66 8 17 85 71 97 34 73 75 6 91 40 96 65 37 74 20 68 23 47 76 55 24 3 30 22 55 5 69 86 54 50 10 59 15 4 36 38 83 60 72 63 78 58 88 93 45 18 94 44 92 81 25 26
         */
        List<Integer> list = Arrays.asList(5,5,5,5,5,5,5,5);
        System.out.println(pickingNumbers(list));
    }
}
