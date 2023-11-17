package com.search.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void peekExamples(){
        var in = IntStream.range(3,8);
        var ins = in.peek(System.out::println).map(x->x*2);
        System.out.println(ins.noneMatch(x-> {
            System.out.println("*****"+x);
            return x % 2 != 0;
        }));
        //Peek:  This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline“.
        Stream.of("one", "two", "three", "four", "five")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
    public static boolean usingInstanceOfAsATypePattern(Object o){
        String name = "Joe";
        return (o instanceof String is) && is.equalsIgnoreCase(name);
    }
    public static void main(String args[]){
        System.out.println(usingInstanceOfAsATypePattern("Liz"));
        System.out.println(usingInstanceOfAsATypePattern("JOE"));
    }
}
