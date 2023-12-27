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
        int index=1;
        for(char l:strs[0].toCharArray()){
            int i=1;
            sb.append(l);
            while (arrayLen>i){
                if((strs[i].length()<=index  || i>=strs[i].length() )&& arrayLen==i) {
                    if(sb.toString().equals(strs[i].substring(0,index)))
                        return sb.toString();
                    else
                        return "";
                }
                if( strs[i].length()>=index && sb.toString().equals(strs[i].substring(0,index)))
                    i++;
                else
                    return sb.toString().substring(0,index-1);
            }
            index++;
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
