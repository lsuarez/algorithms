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
        return searchCommonPrefix(strs[0].substring(0,1), 1,  1, strs);
    }
    private static String searchCommonPrefix(String prefix, int i, int index, String[] strs){
        if((strs[0].length()<=index && i>=strs.length ) || (strs[i].length()<=index  && i>=strs.length)) {
            if(i>=strs.length)
                return prefix;
            if (prefix.equals(strs[i].substring(0, index)))
                return prefix;
            else
                return prefix.substring(0, index - 1);
        }
        if(i>= strs.length-1 && strs[0].length()>index) {
            if(i>= strs.length-1 && strs[0].length()==index)
                return searchCommonPrefix(prefix, i + 1, index, strs);
            return searchCommonPrefix(strs[0].substring(0, index + 1), 1, index + 1, strs);
        }
        if(prefix.equals(strs[i].substring(0, index)))
            return searchCommonPrefix(prefix, i + 1, index, strs);
        else if (prefix.length()<1)
            return "";
        else
            return prefix.substring(0,index-1);
    }
    public static void main(String args[]){

        //["flower","flow","flight"] -> fl
        //"flower","flower","flower","flower" -> flower
        //"ab","a" -> a
        String[] str= {"ab","a"}; //fl
        String[] str2={"flower","flow","flight"};
        String[] str3={"flower","flower","flower","flower"};
        System.out.println(longestCommonPrefix(str));
       // System.out.println(longestCommonPrefix(str2));
       // System.out.println(longestCommonPrefix(str3));
    }
}
