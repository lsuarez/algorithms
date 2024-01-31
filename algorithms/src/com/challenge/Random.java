package com.challenge;


import java.util.HashMap;

public class Random {
    public int flipCoin(){
        return 0;
    }
    public int getValue(int N){
        long nano =System.nanoTime();
        int value = Integer.valueOf((int) nano) % (N+1);
       return Math.abs(value);
    }


    public static void main(String[] args) {
        Random obj= new Random();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<10_000; i++){
             int value = obj.getValue(10);
             if(map.containsKey(value)){
                 int total = map.get(value);
                 total++;
                 map.remove(value);
                 map.put(value, total);
             }else{
                 map.put(value, 1);
             }
        }
        System.out.println(map.toString());

        /*
3
3
2
1
0
3
0
0
2
1
2
3
         */
    }
}
