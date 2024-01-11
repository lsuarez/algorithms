package com.challenge;


import java.util.*;

// Write a program that will count the frequency of the words in the String.
// Example: I think coding is fun.. fun Fun fun!
// Output
// I - 1
// think - 1
// coding - 1
// is - 1
// fun - 3
// Fun - 1
// Sorted [I - 1, is - 2, fun - 3, Fun - 1, think - 1, coding - 1]
public class CountingWords {

    public static HashMap<String, Integer> countWords(String phrase){
        HashMap<String, Integer> counter = new HashMap<>();
        Arrays.stream(phrase.trim().split(" ")).forEach(word->{
            word = word.replaceAll("[^a-zA-Z]", "");
            if(counter.containsKey(word)){
                int total = counter.get(word);
                counter.remove(word);
                total ++;
                counter.put(word, total);
            }else{
                counter.put(word, 1);
            }
        });
        return counter;
    }

    // Sorted [I - 1, is - 2, fun - 3, Fun - 1, think - 1, coding - 1]
    private static SortedSet<Map.Entry<String,Integer>>  ordering(HashMap<String, Integer> words){

            SortedSet<Map.Entry<String,Integer>> sortedEntries = new TreeSet<>(
                    new Comparator<Map.Entry<String,Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                            int res = (Integer.valueOf(o1.getKey().length())).compareTo(o2.getKey().length());
                            if(o1.getKey().toUpperCase().equals(o2.getKey().toUpperCase())) {
                                int compare =o1.getKey().compareTo(o2.getKey());
                                return compare ==0 ? compare : compare> 0 ? -1: 1;
                            }
                            return res != 0 ? res : 1;
                        }
                    }
            );
            sortedEntries.addAll(words.entrySet());
            return sortedEntries;
    }

    public static void main(String args[]){
        HashMap<String, Integer> map = countWords("I33 think coding is fun.. fun Fun is fun!");
        System.out.println(map.toString());
        System.out.println(ordering(map));

    }
}
