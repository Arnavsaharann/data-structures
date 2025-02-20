package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.Stack;

public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(-1);
        stack.push(-100);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }

    public static void sortStack(Stack<Integer> stack){
        if(stack.empty()){
            return;
        }

        int element = stack.pop();
        sortStack(stack);
        inserInSortedOrder(stack,element);
    }

    public static void inserInSortedOrder(Stack<Integer>stack, int element){
        if(stack.empty() || stack.peek() <= element){
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        inserInSortedOrder(stack,element);
        stack.push(temp);
    }

}
