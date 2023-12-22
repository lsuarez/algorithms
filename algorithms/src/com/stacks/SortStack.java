package com.stacks;


import java.util.EmptyStackException;

/**
 * Write a program to sort a stack such that the smallest item are on the top. You
 * can an additional temporary stack, but you may not copy the elements into any other data structure (such as
 * an array). The stack supports the following operations: push, pop, peek and isEmpty.
 */

public class SortStack {
    public static void main(String[] args){

        Stack stack = new Stack();
        stack.pushOrdered(5);
        stack.pushOrdered(3);
        stack.pushOrdered(1);
        stack.pushOrdered(2);
        stack.pushOrdered(1);
    }
}
class Stack{
    private StackNode top;

    private Stack temp;

    private static class StackNode{
        private final int data;
        private StackNode next;
        public StackNode(int data){
            this.data = data;
        }
    }
    public void pushOrdered(int data){
        if(top == null)
            top = new StackNode(data);
        else {
            if (top.data > data) {
                StackNode tmp = new StackNode(data);
                tmp.next = this.top;
                top = tmp;
            } else {
                int current = peek();
                temp= new Stack();
                while (current <= data && !isEmpty()) {
                    temp.push(pop());
                    if(!isEmpty())
                        current = peek();
                }
                push(data);
                while (!temp.isEmpty()) {
                    push(temp.pop());
                }
            }
        }

    }
    public void push(int item){
        StackNode t = new StackNode(item);
        t.next = this.top;
        this.top = t;
    }
    public int peek(){
        if(this.top == null)
            throw new EmptyStackException();
        return this.top.data;
    }
    public boolean isEmpty(){
        return this.top ==null;
    }
    public int pop(){
        if(top == null)
            throw new EmptyStackException();
        int item = top.data;
        this.top = top.next;
        return item;
    }


}
