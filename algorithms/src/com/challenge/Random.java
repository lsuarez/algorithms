package com.challenge;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {

    private List<Integer> initialLoad;

    private int loadFactor;
    public Random(int N){
        initialLoad = new ArrayList<>(N*2);
        loading(N);
        loadFactor=N;

    }
    private void loading(int N){
        int i=0;
        while(initialLoad.size()< N*2) {
            initialLoad.add(i);
            initialLoad.add(i);
            i++;

        }
        Collections.shuffle(initialLoad);
    }
    public int getValue(){
        int value = initialLoad.get(0);
        initialLoad.remove(0);
        checkLoadFactor();
        return value;
    }
    private void checkLoadFactor(){
        if(initialLoad.size()<= loadFactor){
            loading(loadFactor);
        }
    }
    public static void main(String[] args) {
        Random obj= new Random(3);
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        System.out.println(obj.getValue());
        /*
0
1
2
0
1
1
1
0
0
1
2
0
         */
    }
}
