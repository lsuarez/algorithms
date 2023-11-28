package com.stacks;

import java.util.EmptyStackException;

public class SetOfStacks {
    private SetOfStacks next;
    private StackNode top;
    private static final int maxCapacity=2;
    private int currentCapacity=0;
    public void push(int data){
        if(top==null) {
            top = new StackNode(data);
            currentCapacity ++;
        }
        else if(currentCapacity< maxCapacity) {
            StackNode t = new StackNode(data);
            t.next = this.top;
            this.top = t;
            currentCapacity ++;
        }else{
            SetOfStacks currentStack = getNextStack(this);
            StackNode t = new StackNode(data);
            t.next = currentStack.top;
            currentStack.top = t;
            SetOfStacks lastStack = getLastStack();
            currentStack.currentCapacity ++;

            if(currentStack.currentCapacity<currentStack.maxCapacity)
                lastStack.next = currentStack;

        }

    }

    private SetOfStacks getLastStack() {
        SetOfStacks stack = this;
        while(stack.currentCapacity == stack.maxCapacity  && stack.next!= null){
            stack=stack.next;
        }
        return stack;
    }


    private SetOfStacks getNextStack(SetOfStacks stack){
        stack = stack.next;
        if(stack == null){
            return new SetOfStacks();
        }
        if(stack.currentCapacity<stack.maxCapacity){
            return stack;
        }else{
            return getNextStack(stack);
        }
    }
    private class StackNode{
        private int data;
        private StackNode next;

        public StackNode(int data){
            this.data = data;
        }
    }
    private SetOfStacks getLastStackForPop() {
        SetOfStacks stack = this;
        while( stack.next!= null && stack.next.currentCapacity>0){
            stack=stack.next;
        }
        return stack;
    }
    public int pop(){
        if(this.currentCapacity<=0)
            throw new EmptyStackException();
        SetOfStacks currentStack = getLastStackForPop();
        int value = currentStack.top.data;
        currentStack.top = currentStack.top.next;
        currentStack.currentCapacity--;
        return value;
    }

}
