package com.challenge;

import java.util.HashMap;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        if(strs.length==0)
            return "";
        if(strs[0].isEmpty())
            return "";
        StringBuilder sb= new StringBuilder();
        int arrayLen = strs.length;
        int indexOfCharacter=0;
        for(char l:strs[0].toCharArray()){
            int wordNumber=1;
            sb.append(l);
            while (arrayLen>wordNumber){
                char letterToCompare=' ';
                if(strs[wordNumber].length()-1>=indexOfCharacter ) {
                    letterToCompare = strs[wordNumber].charAt(indexOfCharacter);
                }
                if( l == letterToCompare ) {
                    wordNumber++;
                }
                else {

                    if(sb.toString().length()<1) {
                        return "";
                    }
                    return sb.toString().substring(0, indexOfCharacter);
                }
            }
            indexOfCharacter++;
        }
        return sb.toString();
    }

    public static void main(String args[]){

        //["flower","flow","flight"] -> fl
        //"flower","flower","flower","flower" -> flower
        //"ab","a" -> a
        String[] str= {"ab","a"}; //fl
        String[] str2={"flower","flow","flight"};
        String[] str3={"flower","flower","flower","flower"};
        String[] str4= {"a","b"}; // ""
        String[] str5= {"a","a","b"}; // ""
        System.out.println(longestCommonPrefix(str5));
        System.out.println(longestCommonPrefix(str));
        System.out.println(longestCommonPrefix(str2));
        System.out.println(longestCommonPrefix(str3));
        System.out.println(longestCommonPrefix(str4));




    }
}
