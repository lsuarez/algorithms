package com.challenge;

import java.util.*;

public class Calculate {

    static Stack<Integer> sum= new Stack<>();
    public static int calculate(String operations){
        char[] characters = operations.toCharArray();
        int beg=0, end=0, result =0;
        boolean isMultiplicationBefore=false;
        for(char c :characters ){
            if(c=='+' || c=='*'){
                convert(Arrays.copyOfRange(characters,beg,end));
                beg=end+1;
                if(isMultiplicationBefore){
                    int temp = sum.pop()*sum.pop();
                    sum.push(temp);
                    isMultiplicationBefore=false;
                }
                if(c=='*'){
                    isMultiplicationBefore=true;
                }
            }
            end++;
        }
        convert(Arrays.copyOfRange(characters,beg,end));
        int temp =sum.pop();
        if(isMultiplicationBefore){
            temp*=sum.pop();
        }
        while (!sum.isEmpty()){
            result+=sum.pop();
        }
        return temp!=0? (result+temp) :result;
    }

    private static void convert(char[] num){
        int i=num.length-1, level=1;
        int n=0;
        while (i>=0){
            n+=(num[i]-48)*level;
            level=level*10;
            i--;
        }
        sum.push(n);
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
