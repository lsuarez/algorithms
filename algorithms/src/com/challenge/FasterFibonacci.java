package com.challenge;

import java.util.HashMap;

public class FasterFibonacci {
    private static HashMap<Long, Long> calculated;
    static{
        calculated= new HashMap<>();
        calculated.put(Long.valueOf(0), Long.valueOf(0));
        calculated.put(Long.valueOf(1), Long.valueOf(1));
    }
    public static long getFibonacciOf(long n){
        if(n==0) {
            return 0;
        }else{
            if(calculated.containsKey(n)){
                return calculated.get(n);
            }else{
                long value = getFibonacciOf(n-2)+ getFibonacciOf(n-1);
                calculated.put(n, value);
                return  value;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("F("+10+"):"+ getFibonacciOf(10)); //55
        System.out.println("F("+65+"):"+ getFibonacciOf(65)); //17167680177565
    }
}
