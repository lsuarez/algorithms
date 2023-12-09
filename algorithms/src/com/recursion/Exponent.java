package com.recursion;
        /*
        base 1 al 100, exponent 1 al 100_000
         */

public class Exponent {
    private static int calculate(int base, int exp){
        if(exp == 1)
            return base;
        if(exp==2)
            return base*base;
        if(exp ==3)
            return base * calculate(base, 2);
       int result =  calculate(base, exp/2);
       return result * result;
    }
    public static int exponent(int base, int exp){
        if(base<=0 || exp<=0)
            return -1;
        if(exp == 1)
            return base;
        int result =  calculate(base, exp);
        if(exp%2!=0)
            result=result * base;
        return result;
    }
    public static void main(String args[]){
        System.out.println("Calculate exponent of 2 to 8 ="+exponent(2, 8)); //Calculate exponent of 2 to 8 =256
        System.out.println("Calculate exponent of 3 to 5 ="+exponent(3, 5)); //Calculate exponent of 3 to 5 =243
        System.out.println("Calculate exponent of 2 to 6 ="+exponent(2, 6)); //Calculate exponent of 2 to 6 =16
        System.out.println("Calculate exponent of 4 to 1 ="+exponent(4, 1)); //Calculate exponent of 4 to 1 =4
        System.out.println("Calculate exponent of 4 to 1 ="+exponent(4, 0)); //Calculate exponent of 4 to 1 =-1
    }
}
