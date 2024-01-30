package com.challenge;



public class Random {
    public int getValue(int N){
        long nano =System.nanoTime();
        String valueStr= nano+"";
        int max = valueStr.length();
        String sub = valueStr.substring(max-2, max-1);
        int value = Integer.valueOf(sub);
        value = value % (N+1);
        return value;
    }

    public static void main(String[] args) {
        Random obj= new Random();
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));
        System.out.println(obj.getValue(3));

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
