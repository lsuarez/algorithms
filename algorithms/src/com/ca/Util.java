package com.ca;
/*
Next, create another class called Util that contains a method called 'compare'.
The 'compare' method takes in a 'StringCompare' object.
It returns null if the length of the 'first' string plus the length of the 'second' string in the StringCompare object is greater than 10.
Otherwise, it returns the 'second' string from StringCompare.
 */
public class Util {

    public String compare(StringCompare sc){
        if(sc==null) {
            throw new IllegalStateException("StringCompare is null");
        }

        int length1 = sc.getFirst()==null ? 0: sc.getFirst().length();
        int length2 = sc.getSecond()==null ? 0 : sc.getSecond().length();

        return (length1+length2)>10 ? null : sc.getSecond();
    }

    public static void main(String[] args) {
        Util util= new Util();
        StringCompare sc = new StringCompare("", "");
        System.out.println(util.compare(sc));//""
        System.out.println(util.compare(new StringCompare("12345", "12346")));//12346
        System.out.println(util.compare(new StringCompare("12345", "123456")));//null
        System.out.println(util.compare(new StringCompare("  ", "  ***")));//"  ***"
        System.out.println(util.compare(null));//IllegalStateException: StringCompare is null
    }
}
