package com.challenge;



import java.util.Map;
import java.util.TreeMap;

public class Random {

    private int[]probability;
    private double media;
    private int counter=0;
    private int N;
    public Random(int N){
        probability= new int[N+1];
        media = (double)1/(double)N;
        this.N=N;
    }
    public int flipCoin(){
        return Math.random()<0.5?1:0;
    }
    private boolean isValidProbability(int value){

        int localCounter = probability[value];
        if(localCounter >0){
            if((double)probability[value]/(double)counter<media) {
                localCounter++;
                probability[value] = localCounter;
                counter++;
                return true;
            }
            else{
                return false;
            }
        }else{
            probability[value]=1;
            counter++;
            return true;
        }

    }
    private int getValueNotFired(){
        for(int i=0;i<probability.length; i++){
            if(probability[i]>0) {
                if ((double)probability[i] / (double)counter < media) {
                    int localCounter = probability[i];
                    localCounter++;
                    probability[i] = localCounter;
                    counter++;
                    return i;
                }
            }else{
                probability[i] = 1;
                counter++;
                return i;
            }
        }
        return 0;
    }

    public int getValue(){
        int index =0;
        int max = N;
        int midd = N/2;
        while(index<N){
            index ++;
            if(flipCoin()==1) {
                if(flipCoin()==1 && midd<=N && isValidProbability(midd)){
                    return midd;
                }
                if(flipCoin() ==0 && index*2<=N && isValidProbability(index*2)) {
                    return index*2;
                }if(flipCoin() ==1 && max%N <=N && isValidProbability(max%N)) {
                    return max%N;
                }if(flipCoin()==1  && index<=N && isValidProbability(index)){
                    return index;
                }
                if(flipCoin()==0 && max<=N && isValidProbability(max)) {
                    return max;
                }
            } if(flipCoin()==0){
                midd++;
            }else{
                midd--;
            }

                max--;
                index ++;
        }
        return getValueNotFired();
    }


    public static void main(String[] args) {
        Random obj= new Random(100);

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<10_000; i++){
             int value = obj.getValue();
             if(map.containsKey(value)){
                 int total = map.get(value);
                 total++;
                 map.remove(value);
                 map.put(value, total);
             }else{
                 map.put(value, 1);
             }
        }

        /*
Para 10 ->{0=1663, 1=2229, 2=798, 3=466, 4=868, 5=438, 6=815, 7=331, 8=410, 9=1152, 10=830}
Para 100 -> {0=1695, 1=2199, 2=691, 3=241, 4=73, 5=28, 6=13, 7=7, 8=2, 94=4, 95=17, 96=40, 97=99, 98=350, 99=1151, 100=798, 44=1, 45=2, 46=12, 47=53, 48=217, 49=807, 50=425, 51=825, 52=183, 53=47, 54=17, 55=3}

         */
    }
}
