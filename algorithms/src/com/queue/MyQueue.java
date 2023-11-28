package com.queue;

import com.stacks.MyStack;

public class MyQueue {
    private MyStack initialStack= new MyStack();
    private MyStack orderedStack= new MyStack();

    public void add( int value){
        initialStack.push(value);
    }
    public void orderingStack(){
        if(orderedStack.isEmpty()){
            while(!initialStack.isEmpty()){
                orderedStack.push(initialStack.pop());
            }
        }
    }
    public int peek(){
        orderingStack();
        return (Integer)orderedStack.peek();
    }
    public int remove(){
        orderingStack();
        return (Integer)orderedStack.pop();
    }
}
