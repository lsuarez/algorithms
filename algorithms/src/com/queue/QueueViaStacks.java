package com.queue;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueViaStacks {
    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.remove() +" = 1");
        System.out.println(queue.remove() +" = 2");
    }
}
