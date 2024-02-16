package com.arrays;

public class ReversAString {

    public static String reverseString(String word){
        char []characters = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=characters.length-1; i>=0; i--){
            sb.append(characters[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseString("Home Depot"));//topeD emoH
    }
}
