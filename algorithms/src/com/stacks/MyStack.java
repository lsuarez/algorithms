package com.stacks;

import java.util.EmptyStackException;

public class MyStack<T>  {
    public int getMinimum() {
        return min;
    }


    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }
    }
    private StackNode<T> top;
    private int min= Integer.MAX_VALUE;
    public T pop(){
        if(top == null)
            throw new EmptyStackException();
        T item = top.data;
        this.top = top.next;
        return item;
    }
    public void push(T item){
        StackNode<T> t = new StackNode<>(item);
        t.next = this.top;
        this.top = t;
        if (this.min> (Integer)item){
            this.min = (Integer)item;
        }
    }
    public T peek(){
        if(this.top == null)
            throw new EmptyStackException();
        return this.top.data;
    }
    public boolean isEmpty(){
        return this.top ==null;
    }
}
