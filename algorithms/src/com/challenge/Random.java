package com.challenge;



import java.util.Map;
import java.util.TreeMap;

public class Random {

    private int n;
    private int maxBinary=1;
    public Random(int N){
        int counter=0;
        this.n=N;
        while(maxBinary<N){
            maxBinary=maxBinary*2;
            counter++;
        }
        maxBinary=counter;
    }

    public int flipCoin(){
        return Math.random()<0.5?1:0;
    }

    public int getValue(){
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < maxBinary; i++) {
            int bitRandom = flipCoin();
            binary.append(bitRandom);
        }
        int value = Integer.parseInt(binary.toString(), 2);
        if(value<= n)
            return  value;

        return getValue();
    }


    public static void main(String[] args) {
        Random obj= new Random(10);

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
System.out.println(map.toString());
        /*
20->{0=468, 1=462, 2=480, 3=483, 4=492, 5=458, 6=509, 7=529, 8=461, 9=464, 10=507, 11=480, 12=458, 13=485, 14=468, 15=461, 16=480, 17=466, 18=457, 19=475, 20=457}
10->{0=929, 1=921, 2=883, 3=915, 4=957, 5=933, 6=893, 7=887, 8=827, 9=929, 10=926}
         */
    }
}
