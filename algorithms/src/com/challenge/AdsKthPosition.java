package com.challenge;

import java.util.*;

public class AdsKthPosition {


// ads_1              1595268625
// ads_2              1595268626
// ads_1              1595268627
// ads_3              1595268628
// ads_4              1595268629
// ads_2              1595268629
// ads_1              1595268631
// ads_5              1595268632
// ...

// getCommonAds(k) - return the top k ads with the highest number of impressions
// getCommonAds(1) - ads_1
// getCommonAds(2) - ads_1, ads_2
// getCommonAds(3) - ads_1, ads_2, ads_4 OR
//               - ads_1, ads_2, ads_3
// getCommonAds(10) - ads_1, ads_2, ads_3, ads_5, ads_4

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


    // Input format
    // List<String> - ["ads_1,1595268625", "..."]

    public static List<String> getCommonAds(int k, List<String> data){

        PriorityQueue<Map.Entry<String,Integer>> processedData = new PriorityQueue<>(k,Map.Entry.comparingByValue());
        HashMap<String, Integer> map = new HashMap<>();
        for(String d:data){
            String key = d.split(",")[0];
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        }
        for(Map.Entry<String,Integer> mp: map.entrySet()){
            processedData.add( mp);
            if(processedData.size()>k)
                processedData.poll();
        }
        LinkedList<String> keys = new LinkedList<>();
        while(!processedData.isEmpty()){
            keys.addFirst(processedData.poll().getKey());
        }
        return keys;
    }


    /*
    BigO->N
     */
    public static void main(String[] args) {
        List<String> data= new ArrayList<>();
        data.add("ads_1,1595268625");
        data.add("ads_2,1595268626");
        data.add("ads_1,1595268627");
        data.add("ads_3,1595268628");
        data.add("ads_4,1595268629");
        data.add("ads_2,1595268629");
        data.add("ads_1,1595268629");
        data.add("ads_5,1595268629");
        System.out.println(getCommonAds(2, data));// ads_1, ads_2
        System.out.println(getCommonAds(1, data));// ads_1
        System.out.println(getCommonAds(3, data));//ads_1, ads_2,ads_#
        System.out.println(getCommonAds(10, data));
    }
}


