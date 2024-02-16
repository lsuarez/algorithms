package com.challenge;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.stream.Stream;

public class FasterFibonacci {
    private static HashMap<BigInteger, BigInteger> calculated;
    static{
        calculated= new HashMap<>();
        calculated.put(BigInteger.ZERO, BigInteger.ZERO);
        calculated.put(BigInteger.ONE, BigInteger.ONE);
    }
    public static BigInteger getFibonacciOf(BigInteger n){
        if(n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }else{
            if(calculated.containsKey(n)){
                return calculated.get(n);
            }else{
                BigInteger value = getFibonacciOf(n.subtract(BigInteger.TWO)).add( getFibonacciOf(n.subtract(BigInteger.ONE)));
                calculated.put(n, value);
                return  value;
            }
        }
    }

    public static BigInteger streamFibonacci(long n) {
        return Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE},
                        p -> new BigInteger[]{p[1], p[0].add(p[1])})
                .limit(n)
                .reduce((a, b) -> b)
                .get()[0];
    }

    public static void main(String[] args) {
      //  System.out.println("F("+65+"):"+ getFibonacciOf(BigInteger.valueOf(99991))); //2788724563990792802
        System.out.println("F("+65+"):"+ streamFibonacci( 99991)); //17167680177565
    }
}
