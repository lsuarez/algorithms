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
    static Map<String,Integer> procecedData;

    public static List<String> getCommonAds(int k, List<String> data){
        processData(data);
        Set set = procecedData.entrySet();
        Iterator it = set.iterator();
        List<String> keys = new ArrayList<>();
        int index=0;
        while(it.hasNext() && index<k){
            Map.Entry mp = (Map.Entry)it.next();
            keys.add(mp.getKey().toString());
            index++;
        }

        return keys;
    }
    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k2).compareTo(
                        map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    private static void processData(List<String> data){
        procecedData= new TreeMap<>();
        for(String d:data){
            String key = d.split(",")[0];
            int total =0;
            if(procecedData.containsKey(key)){
                total= procecedData.get(key);
                total++;
                procecedData.remove(key);
                procecedData.put(key, total);
            }else{
                procecedData.put(key, total);
            }
        }
        procecedData = valueSort(procecedData);

    }
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


