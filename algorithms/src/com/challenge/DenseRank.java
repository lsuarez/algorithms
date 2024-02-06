package com.challenge;

import java.util.*;

public class DenseRank {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();
        int index =1;
        for(Integer n: ranked){
            if(!map.containsKey(n)){
                map.put(n, index);
                index++;
            }
        }
        for(int i=0; i<player.size(); i++){
            int p = player.get(i);
            if(map.containsKey(p)){
                result.add(map.get(p));
            }else{
                map.put(p, 0);
                map =updateRank(map, p);
                result.add(map.get(p));
            }
        }
        return result;
}

    private static TreeMap<Integer,Integer> updateRank(TreeMap<Integer, Integer> map, int n){

        int index =1;
        for(Map.Entry<Integer,Integer> me: map.entrySet()){
            if(me.getKey() == n) {
                map.put(me.getKey(), index);
            }
            index ++;
        }
        return map;
    }

    public static void main(String[] args) {
        //100 100 50 40 40 20 10
        //4
        //5 25 50 120
        List<Integer> ranked = new ArrayList<>();
        ranked.add(100);
        ranked.add(100);
        ranked.add(50);
        ranked.add(40);
        ranked.add(40);
        ranked.add(20);
        ranked.add(10);
        List<Integer> player = Arrays.asList(5,25,50,120);
        climbingLeaderboard(ranked,player);

    }
}
