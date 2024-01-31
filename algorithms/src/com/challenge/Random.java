package com.challenge;


import java.util.HashMap;

public class Random {
    public int flipCoin(){
        return Math.random()<0.5?1:0;
    }
    public int getValue(int N){
        int index =0;
        int max = N;
        int midd = N/2;
        while(index<N){
            if(flipCoin()==0){
                midd++;
                index ++;
            }else{
                midd--;
                max--;
            }

            if(flipCoin()==1) {
                if(flipCoin() ==0 && index<=N) {
                    return index;
                }if(flipCoin()==0 && max<=N) {
                    return max;
                }else if(midd<=N){
                    return midd;
                }
            }


        }
        return 0;
    }


    public static void main(String[] args) {
        Random obj= new Random();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<10_000; i++){
             int value = obj.getValue(100);
             if(map.containsKey(value)){
                 int total = map.get(value);
                 total++;
                 map.remove(value);
                 map.put(value, total);
             }else{
                 map.put(value, 1);
             }
        }
        System.out.println(map.toString());

        /*
Para 10 ->{0=1663, 1=2229, 2=798, 3=466, 4=868, 5=438, 6=815, 7=331, 8=410, 9=1152, 10=830}
Para 100 -> {0=1695, 1=2199, 2=691, 3=241, 4=73, 5=28, 6=13, 7=7, 8=2, 94=4, 95=17, 96=40, 97=99, 98=350, 99=1151, 100=798, 44=1, 45=2, 46=12, 47=53, 48=217, 49=807, 50=425, 51=825, 52=183, 53=47, 54=17, 55=3}

         */
    }
}
