package com.challenge;

public class Calculate {

    public static int calculate(String operations){
        StringBuilder sb = new StringBuilder();
        int result=0;
        for(char c: operations.toCharArray()){
            if(c=='+'){
                result+= multiplier(sb.toString());
                sb=new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        result+= multiplier(sb.toString());
        return result;
    }
    private static int multiplier(String operations){
        StringBuilder sb = new StringBuilder();
        int result =1;
        for(char n: operations.toCharArray()){
            if(n=='*') {
                result *= Integer.valueOf(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(n);
            }
        }
        result *= Integer.valueOf(sb.toString());

        return result;
    }
    public static void main(String[] args) {
        System.out.println(calculate("3+3*3")); //12
        System.out.println(calculate("5+5+8"));//18
        System.out.println(calculate("12*3*2"));//72
        System.out.println(calculate("30+11*56+2"));//648
    }
}
