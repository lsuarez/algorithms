package com.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class QueueWithStacks {
     Stack<Integer> leftStack = new Stack<>();
     Stack<Integer> rightStack = new Stack<>();
    public  void compute( List<List<Integer>> steps){

        for(List<Integer> commands: steps){
            switch(commands.get(0)){
                case 1:
                    enqueue(commands.get(1));
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    System.out.println(peek());
                    break;
            }
        }
    }


    void enqueue(int item) {
        leftStack.push(item);
    }

    int dequeue() {
        transferIfNeeded();
        return rightStack.pop();
    }

    int peek() {
        transferIfNeeded();
        return rightStack.peek();
    }

    void transferIfNeeded() {
        if (rightStack.empty()) {
            while (!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
        }
    }



    public static void main(String[] args) {
        List<List<Integer>> commands = new ArrayList<>();
        commands.add(Arrays.asList(1,1));
        commands.add(Arrays.asList(2));
        commands.add(Arrays.asList(1,2));
        commands.add(Arrays.asList(1,3));
        commands.add(Arrays.asList(1,4));
        commands.add(Arrays.asList(1,5));
        commands.add(Arrays.asList(2));
        commands.add(Arrays.asList(1,6));
        commands.add(Arrays.asList(1,7));
        commands.add(Arrays.asList(1,8));
        commands.add(Arrays.asList(3));
      //  compute(commands);
       // 3




        List<List<Integer>> commands2 = new ArrayList<>();
        commands2.add(Arrays.asList(1,42));
        commands2.add(Arrays.asList(2));
        commands2.add(Arrays.asList(1,14));
        commands2.add(Arrays.asList(3));
        commands2.add(Arrays.asList(1,28));
        commands2.add(Arrays.asList(3));
        commands2.add(Arrays.asList(1,60));
        commands2.add(Arrays.asList(1,78));
        commands.add(Arrays.asList(2));
        commands.add(Arrays.asList(2));
        QueueWithStacks obj = new QueueWithStacks();
        obj.compute(commands2);
    }
}
