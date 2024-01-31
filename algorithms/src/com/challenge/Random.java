package com.challenge;



public class Random {
    public int getValue(int N){
        String nStr= N+"";
        int lenOfN= nStr.length();
        long nano =System.nanoTime();
        String valueStr= nano+"";
        int max = valueStr.length();
        String sub = valueStr.substring(max-lenOfN, max);
        int value = Integer.valueOf(sub);
        value = value % (N+1);
        return value;
    }

    public static void main(String[] args) {
        Random obj= new Random();
        System.out.println(obj.getValue(1500));
        System.out.println(obj.getValue(1500));
        System.out.println(obj.getValue(1500));
        System.out.println(obj.getValue(1500));
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
