package com.strings;
//Basic string compression aaabbbccccdd -> a3b3c4d2
public class StringCompression {

    public static String compress(String word){
        //Get compress length
        int compressLen = getCompressLen(word);
        StringBuilder sb = new StringBuilder(compressLen*2);
        int counter = 0;
        for(int i=0; i<word.length(); i++ ) {
                counter ++;
            if( i+1 >= word.length() || word.charAt(i) != word.charAt(i+1)){
                sb.append(word.charAt(i)).append(counter);
                counter=0;
            }
        }
        return sb.toString();
    }
    private static int getCompressLen(String word){
        char[] characters = word.toCharArray();
        int counter = 0;
        for(int i=0; i<word.length(); i++ ){

            if(i+1 >= word.length() || characters[i] != characters[i+1]){
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args){

        System.out.println(compress("jjjttowwwwwyyyyyyyy"));

    }
}


