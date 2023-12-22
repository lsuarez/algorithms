package com.stacks;

public class StackMin {
    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();
        stack.push(34);
        stack.push(12);
        stack.push(4);
        stack.push(90);
        stack.push(19);
        System.out.println("Min value is: "+stack.getMinimum()); //It is printing 4
    }
}
