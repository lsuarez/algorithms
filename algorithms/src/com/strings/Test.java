package com.strings;

public class Test {
}

sealed class MyClass permits MyExamCloud{}
final class MyExamCloud extends MyClass{
    public static void main(String[] as){
        MyClass mc = new MyClass();

            System.out.println("MyInterface");
    }
}
