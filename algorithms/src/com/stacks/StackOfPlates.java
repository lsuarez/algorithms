package com.stacks;

/**
 * Imagine a(literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in the real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds
 * capacity. SetOfStacks push() and pop() should behave identically to a single stack (that is, pop() should
 * return the same values as it would if there were just a single stack).
 */

public class StackOfPlates {
    public static void main(String args[]){
        SetOfStacks stack = new SetOfStacks();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
