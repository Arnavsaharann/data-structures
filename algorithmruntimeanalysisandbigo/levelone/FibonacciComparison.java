package com.bridgelabz.algorithmruntimeanalysisandbigo.levelone;

public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 40;

        long start, end;

        start = System.nanoTime();
        int recursiveResult = recursiveFibonacci(n);
        end = System.nanoTime();
        System.out.println("Recursive Fibonacci Result: " + recursiveResult);
        System.out.println("Recursive Time: " + (end - start) / 1e6 );

        start = System.nanoTime();
        int iterativeResult = iterativeFibonacci(n);
        end = System.nanoTime();
        System.out.println("Iterative Fibonacci Result: " + iterativeResult);
        System.out.println("Iterative Time: " + (end - start) / 1e6);
    }

    static int recursiveFibonacci(int n) {
        if (n <= 1) return n;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    static int iterativeFibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
