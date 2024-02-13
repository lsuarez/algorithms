package com.arrays;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        int len=s.length();
        if(s.length()%2 !=0 ){
            return "NO";
        }
        HashMap<Character,Character> dictionary = new HashMap<>();
        dictionary.put( '}', '{');
        dictionary.put( ']', '[');
        dictionary.put( ')', '(');
        Stack<Character> stack= new Stack<>();
        for(char c: s.toCharArray()){
            if( c==']' || c== ')' || c=='}'){

                if(stack.isEmpty()  || stack.pop()!=dictionary.get(c)){
                    return "NO";
                }
            }else{
                stack.push(c);
            }
        }
        if(!stack.isEmpty()){
            return "NO";
        }
        return "YES";

    }
/*
    Big O - >N
 */
    public static void main(String[] args) {
        /*
        {[()]}          first s = '{(([])[])[]}'
        {[(])}          second s = '{[(])}'
        {{[[(())]]}}    third s ='{{[[(())]]}}'
         */
        System.out.println(isBalanced("{(([])[])[]}")); //YES
        System.out.println(isBalanced("{[(])}"));       //NO
        System.out.println(isBalanced("{{[[(())]]}}")); //YES
    }
}
