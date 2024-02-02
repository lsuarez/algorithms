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
    static PriorityQueue<Map.Entry<String,Integer>> processedData;


    public static List<String> getCommonAds(int k, List<String> data){
        processData(data,k);
        Iterator it = processedData.iterator();
        List<String> keys = new ArrayList<>();
        while(it.hasNext()){
            Map.Entry mp = (Map.Entry)it.next();
            keys.add(mp.getKey().toString());
        }

        return keys;
    }


    private static void processData(List<String> data, int k){

        processedData = new PriorityQueue<>(k,Map.Entry.comparingByValue());
        HashMap<String, Integer> map = new HashMap<>();
        for(String d:data){
            String key = d.split(",")[0];
            int total =0;
            if(map.containsKey(key)){
                total= map.get(key);
                total++;
                map.remove(key);
                map.put(key, total);
            }else{
                map.put(key, 1);
            }
        }
        Set set = map.entrySet();
        Iterator it= set.iterator();
        while(it.hasNext()){
            Map.Entry mp = (Map.Entry)it.next();
            processedData.add( mp);
            if(processedData.size()>k)
                processedData.poll();
        }
    }
    /*
    BigO->NlogN
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


