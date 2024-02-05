package com.challenge;

public class TimeInWords {

    private static String convert(int m){
        switch(m){
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eighth";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            case 20: return "twenty";
            case 21: return "twenty one";
            case 22: return "twenty two";
            case 23: return "twenty three";
            case 24: return "twenty four";
            case 25: return "twenty five";
            case 26: return "twenty six";
            case 27: return "twenty seven";
            case 28: return "twenty eighth";
            case 29: return "twenty nine";
            case 31: return "thirty one";
            case 32: return "thirty two";
            default: return "Not valid one";
        }
    }
    public static String timeInWords(int h, int m) {
        StringBuilder sb = new StringBuilder();
        if(m==0){
            return sb.append(convert(h)).append(" o' clock").toString();
        }
        if(m==1){
            return sb.append(convert(m)).append(" minute past ").append(convert(h)).toString();
        }
        if(m>0 && m<15 || m>15 && m<30){
            return sb.append(convert(m)).append(" minutes past ").append(convert(h)).toString();
        }
        if(m==15){
            return sb.append("quarter past ").append(convert(h)).toString();
        }
        if(m==30){
            return sb.append("half past ").append(convert(h)).toString();
        }
        if(m>30 && m<45){
            return sb.append(convert(60-m)).append(" minutes to ").append(convert(h+1)).toString();
        }
        if(m==45){
            return sb.append("quarter to ").append(convert(h+1)).toString();
        }
        if(m>45){
            return sb.append(convert(60-m)).append(" minutes to ").append(convert(h+1)).toString();
        }
        return "";

    }

    public static void main(String[] args) {
        System.out.println(timeInWords(5,47));//thirteen minutes to six
        System.out.println(timeInWords(3,0));//three o' clock
        System.out.println(timeInWords(7,17));//seventeen minutes past seven
        System.out.println(timeInWords(1,1));//one minute past one

    }
}
