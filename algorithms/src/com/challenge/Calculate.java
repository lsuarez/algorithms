package com.challenge;

public class Calculate {

    public static int calculate(String operations){
        String[] op= operations.split("\\+");
        int result=0;
        for(String sum:op) {
            result+= multiplier(sum);
        }
        return result;
    }
    private static int multiplier(String operations){
        String[] op= operations.split("\\*");
        int result =1;
        for(String n: op){
            result*=Integer.valueOf(n);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(calculate("3+3*3")); //12
        System.out.println(calculate("5+5+8"));//18
        System.out.println(calculate("12*3*2"));//72
        System.out.println(calculate("30+11*56+2"));//648
    }
}
