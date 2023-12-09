package com.recursion;
        /*
        base 1 al 100, exponent 1 al 100_000
         */

public class Exponent {
    private static int array[];
    private static int calculate(int base, int exp){
        if(exp == 1) {
            array[0]=base;
            return base;
        }
       int result =  calculate(base, exp-1);
        array[exp-1]=base* result;
       return array[exp-1];
    }
    public static int exponent(int base, int exp){
        array = new int[exp];
        if(base<=0 || exp == 0)
            return -1;
        if(exp == 1)
            return base;
        int result =  calculate(base, exp/2);
        if(exp%2==0)
            return result*result;
        return result *result * base;
    }
    public static void main(String args[]){
        System.out.println("Calculate exponent of 2 to 14 ="+exponent(2, 14)); //Calculate exponent of 2 to 8 =256
        System.out.println("Calculate exponent of 3 to 5 ="+exponent(3, 5)); //Calculate exponent of 3 to 5 =243
        System.out.println("Calculate exponent of 2 to 10 ="+exponent(2, 10)); //Calculate exponent of 2 to 6 =16
        System.out.println("Calculate exponent of 4 to 1 ="+exponent(4, 1)); //Calculate exponent of 4 to 1 =4
        System.out.println("Calculate exponent of 4 to 1 ="+exponent(4, 0)); //Calculate exponent of 4 to 1 =-1
    }
}
