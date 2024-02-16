package com.challenge;

import java.util.*;

public class Calculate {

    public static int calculate(String s) {
        char[] array = s.toCharArray();
        Stack<Integer> integers = new Stack<>();
        int readIndex=0;
        while(readIndex<array.length){
            if(isNumeric(array[readIndex])){
                int number=0;
                while(readIndex<array.length && isNumeric(array[readIndex])){
                    number = number *10 + (array[readIndex]-'0');
                    readIndex++;
                }
                integers.push(number);
            }else if(array[readIndex]== '*'){
                readIndex++;
                int number=0;
                while(readIndex<array.length && isNumeric(array[readIndex])){
                    number = number *10 + (array[readIndex]-'0');
                    readIndex++;
                }
                integers.push(integers.pop()*number);
            }else{
                readIndex++;
            }
        }
        int result =0;
        while(!integers.isEmpty()){
            result+= integers.pop();
        }
        return result;
    }
    private static boolean isNumeric(char c){
        return c>='0' && c<='9';
    }

    public static void main(String[] args) {
        System.out.println(calculate("1+2*3*4+5+6+7*8*9+10")); //550
        System.out.println(calculate("3+2*3+1*4")); //13
        System.out.println(calculate("3+3*11")); //36
        System.out.println(calculate("5+5+8"));//18
        System.out.println(calculate("12*3*2"));//72
        System.out.println(calculate("30+11*56+2"));//648


    }
}
