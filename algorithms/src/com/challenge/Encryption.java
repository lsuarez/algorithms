package com.challenge;

public class Encryption {
    public static String encryption(String s) {
        int row = (int)Math.sqrt(s.length());
        int col = row;
        if(row*col <s.length()){
            col++;
        }
        int index=0;
        StringBuilder sb = new StringBuilder();
        char []letters = s.toCharArray();
        int i=0;
        int counter=0;
        while(counter<=(s.length()-1)){
            index=i;
            while(index<=s.length()-1){
                sb.append(letters[index]);
                counter++;
                index+=col;
            }
            sb.append(" ");
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(encryption("iuo"));//io u
        System.out.println(encryption("a"));//a
        System.out.println(encryption("feedthedog"));//fto ehg ee dd
        System.out.println(encryption("iffactsdontfittotheorychangethefacts"));//isieae fdtonf fotrga anoyec cttctt tfhhhs

    }
}
