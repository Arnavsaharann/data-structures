package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        queue.peek();
        queue.pop();
        queue.peek();
        queue.pop();
        queue.pop();
        queue.peek();
        queue.pop();
        queue.pop();
        queue.peek();

    }
}

class Queue{
    private Stack<Integer> input;
    private Stack<Integer> output;

    public Queue() {
        input = new Stack<>();  // Initialize the input stack
        output = new Stack<>(); // Initialize the output stack
    }

    public void push(int element){
        input.push(element);
        System.out.println("the number " + element + " is pushed into the queue");
        return;
    }

    public void pop(){
        if(!output.empty()){
            System.out.println("The Popped element is: " + output.pop());
            return;
        }else{
            while(!input.empty()){
                int element = input.pop();
                output.push(element);
            }
            if(!output.empty()){
                int element = output.pop();
                System.out.println("The Popped element is: " + element);
                return;
            }
            System.out.println("The Queue is empty");
        }
    }

    public void peek(){
        if(!output.empty()){
            System.out.println("element in the front is: " + output.peek());
            return;
        }else {
            while (!input.empty()) {
                int element = input.pop();
                output.push(element);
            }
            if (!output.empty()) {
                System.out.println("element in the front is: " + output.peek());
                return;
            }
            System.out.println("The Queue is empty");
        }
    }
}


