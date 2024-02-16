package com.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonDivisibleSubset {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int i=0, result=0, max=3, n=1;
        if(s.size()%2==0){
            max=2;
        }
        while(i<s.size()){
            if(max*n> s.size()){
                result+= getCounting(k, s.subList(i, s.size()));
            }else {
                result += getCounting(k, s.subList(i, max * n));
            }
            i+=max;
            n++;
        }
        return result;
    }
    private static int getCounting(int k, List<Integer> s){
        int counter =0;
        for(int i=0; i<s.size(); i++){
            for(int j=i+1; j<s.size(); j++){

                if((s.get(i)+s.get(j))% k ==0){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        //278 576 496 727 410 124 338 149 209 702 282 718 771 575 436
       // List<Integer>list = Arrays.asList(278 ,576, 496, 727, 410, 124 ,338, 149 ,209, 702, 282 ,718, 771 ,575 ,436);
       // System.out.println(nonDivisibleSubset(7,list));

        //1 7 2 4
        List<Integer>list = Arrays.asList(1,7,2,4);
        System.out.println(nonDivisibleSubset(3,list));


    }
}
