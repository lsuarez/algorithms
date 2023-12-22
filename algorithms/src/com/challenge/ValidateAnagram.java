package com.challenge;

import java.util.HashMap;

public class ValidateAnagram {
    /**
     *
     *An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     * For example, the word anagram itself can be rearranged into nag a ram
     *
     * We want to create a method that : For a given input of two strings,
     * return a boolean TRUE if the input strings are anagrams, false otherwise.
     * "William Shakespeare" = "I am a weakish speller"
     * “Listen” and “Silent”
     */
    public static boolean isAnagram(String str1, String str2){
        if(str1 == null ||str1.trim().isEmpty() || str2==null   || str2.trim().isEmpty() )
            return false;

        str1= str1.trim().toLowerCase();
        str2= str2.trim().toLowerCase();

        HashMap<Character, Integer> stored = new HashMap<>();
        for(char c: str1.toCharArray()){
            if(c==' ')
                continue;
            if(stored.containsKey(c)){
                int total = stored.get(c);
                total++;
                stored.remove(c);
                stored.put(c, total);
            }else
                stored.put(c, 1);
        }
        for(char c: str2.toCharArray()) {
            if(c==' ')
                continue;
            if(stored.containsKey(c)){
                int total = stored.get(c);
                total--;
                stored.remove(c);
                if(total>0)
                    stored.put(c, total);
            }
            else
                return false;
        }
        return stored.isEmpty();
    }
    public static void main(String[] args){
        //“Listen” and “Silent”
        System.out.println(isAnagram("Listen","Silent"));
        System.out.println(isAnagram("Ronald Wilson Reagan","Insane anglo warlord"));
        //'Georgia', 'navy sin panel'
        System.out.println(isAnagram("Georgia","navy sin panel"));
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller"));

    }
}
