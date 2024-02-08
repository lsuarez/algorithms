package com.challenge;

import java.util.*;

public class DenseRank {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> uniques = new LinkedList<>();
        int previous =0;
        for(int i=0;i<ranked.size();i++){
            if(i==0){
                previous= ranked.get(i);
                uniques.add(previous);
            }
            if(ranked.get(i)!= previous){
                    previous=ranked.get(i);
                    uniques.add(ranked.get(i));
            }
        }
        for(int i=0;i< player.size();i++){
            if(uniques.isEmpty()){
                result.add(1);
            }
            else if(player.get(i)<uniques.getLast()){
                result.add(uniques.size()+1);
            }else {
                while(!uniques.isEmpty() && player.get(i)>=uniques.getLast() ){
                    uniques.removeLast();
                }
                result.add(uniques.size()+1);
            }
        }
        return result;
    }
/*
    BigO NM
 */
    public static void main(String[] args) {
        //100 100 50 40 40 20 10
        //4
        //5 25 50 120
      //  List<Integer> ranked = Arrays.asList(100 ,90 ,90, 80 ,75 ,60);
   /*     ranked.add(100);
        ranked.add(100);
        ranked.add(50);
        ranked.add(40);
        ranked.add(40);
        ranked.add(20);
        ranked.add(10);

    */ //(5,25,50,120
      //  List<Integer> player = Arrays.asList(50, 65 ,77 ,90 ,102);//
        List<Integer> ranked = Arrays.asList(1);
        List<Integer> player = Arrays.asList(1,1);
        climbingLeaderboard(ranked,player);
        System.out.println(Math.sqrt(12));

    }
}
