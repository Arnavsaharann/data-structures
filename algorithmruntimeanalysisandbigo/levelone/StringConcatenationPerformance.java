package com.bridgelabz.algorithmruntimeanalysisandbigo.levelone;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        long start, end;

        start = System.nanoTime();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += text;
        }
        end = System.nanoTime();
        System.out.println("String Time: " + (end - start) / 1e6 );

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1e6 );

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1e6 );
    }
}
