package com.challenge;

import java.util.*;

public class Calculate {

    private static HashMap<Character, Integer> dictionary;
    private static Stack<Integer> sum= new Stack<>();
    private static Stack<Integer> mul= new Stack<>();
    static {
        dictionary= new HashMap<>();
        dictionary.put('0',0);
        dictionary.put('1',1);
        dictionary.put('2',2);
        dictionary.put('3',3);
        dictionary.put('4',4);
        dictionary.put('5',5);
        dictionary.put('6',6);
        dictionary.put('7',7);
        dictionary.put('8',8);
        dictionary.put('9',9);
    }
    public static int calculate(String operations){

        LinkedList<Integer> value= new LinkedList<>();
        boolean isLastSum=false, isNextMul=false;
        for(char c: operations.toCharArray()){
            if(c=='*'){
                    mul.push(convert(value));
                    value = new LinkedList<>();
                    isLastSum = false;
                    isNextMul = true;

            }else if(c=='+'){
                if(isNextMul){
                    int temp=convert(value);
                    while(!mul.isEmpty()){
                        temp*=mul.pop();
                    }
                    sum.push(temp);
                    isNextMul=false;
                }else {
                    sum.push(convert(value));
                }
                value= new LinkedList<>();
                isLastSum=true;
            }else{
                value.add(dictionary.get(c));
            }
        }
        if(isLastSum){
            sum.push(convert(value));
        }else{
            mul.push(convert(value));
        }
        int result=1;
        if(mul.isEmpty()){
            result=0;
        }
        while(!mul.isEmpty()){
            result*=mul.pop();
        }
        while(!sum.isEmpty()){
            result+=sum.pop();
        }
        return result;
    }
    private static int convert(LinkedList<Integer> num){
        int i=0, level=1;
        int sum=0;
        while (i<=num.size()){
            sum+=num.getLast()*level;
            level=level*10;
            i++;
            num.removeLast();
        }
        return sum;
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
