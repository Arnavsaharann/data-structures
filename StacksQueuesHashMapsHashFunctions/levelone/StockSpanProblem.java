package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.Stack;
import java.util.ArrayList;

public class StockSpanProblem {
    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(100);
        prices.add(80);
        prices.add(60);
        prices.add(70);
        prices.add(60);
        prices.add(75);
        prices.add(85);

        ArrayList<Integer> spans = calculateSpan(prices);
        System.out.println("Stock Spans: " + spans);
    }

    public static ArrayList<Integer> calculateSpan(ArrayList<Integer> prices) {
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();  // Stack stores indices

        for (int i = 0; i < prices.size(); i++) {

            while (!stack.isEmpty() && prices.get(stack.peek()) <= prices.get(i)) {
                stack.pop();
            }


            int spanValue;
            if (stack.isEmpty()) {
                spanValue = i + 1; // No previous greater element
            } else {
                spanValue = i - stack.peek();
            }
            span.add(spanValue);

            stack.push(i);
        }

        return span;
    }
}
