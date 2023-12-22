package com.recursion;
        /*
        base 1 al 100, exponent 1 al 100_000
         */

public class Exponent {

    /*
    si n==1 entonces retornas base;
    n es multiplo de 2 entonces retorno calculo(n/2)* calculo(n/2)
    si n no es multiplo de 2 retorno calculo(n/2)* calculo(n/2) * base
    Big O: Log(exp)
     */
    public static int pow(int base, int exp){
        if(exp == 0)
            return 1;
        if(exp ==1)
            return base;
        int result = pow(base, exp / 2);
        result = result * result;
        if(exp%2==0)
            return result;
        else
            return result * base;

    }
    public static void main(String[] args){
        long inicio = System.currentTimeMillis();
        System.out.println("Calculate pow of 2 to 14 ="+pow(2, 900_000_000)); //Calculate pow of 2 to 14 =16384
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo transcurrido:"+(fin-inicio));
        System.out.println("Calculate pow of 3 to 5 ="+pow(3, 5)); //Calculate pow of 3 to 5 =243
        System.out.println("Calculate pow of 2 to 10 ="+pow(2, 10)); //Calculate pow of 2 to 10 =1024
        System.out.println("Calculate pow of 4 to 1 ="+pow(4, 1)); //Calculate pow of 4 to 1 =4
        System.out.println("Calculate pow of 4 to 1 ="+pow(4, 0)); //Calculate pow of 4 to 1 =-1
    }


}
