package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FraudulentActivity {

    public static int activityNotifications(List<Integer> expenditure, int d) {

        int[] array=expenditure.stream().mapToInt( (Integer i) -> i.intValue() ).toArray();
        int subarray[] = new int[d];
        System.arraycopy(array, 0, subarray, 0, d);
        int index =0,   counter=0 , median=0;
        Arrays.sort(subarray);

        while(d+index<array.length-1){

            median = subarray[(index+d)/2];
            if(array[d+index]>=(2*median)){
                counter++;
            }
            index++;
            subarray=Arrays.copyOfRange(array, index, index+d);
            Arrays.sort(subarray);
        }
        return counter;
    }

    public static void main(String[] args) {
        //2 3 4 2 3 6 8 4 5
        List<Integer>list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(4);
        list.add(5);
        System.out.println(activityNotifications(list,5));
    }


}
