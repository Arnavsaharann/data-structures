package com.bridgelabz.algorithmruntimeanalysisandbigo.levelone;

import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size / 2;

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long start, end;

        start = System.nanoTime();
        boolean arrayFound = linearSearch(array, target);
        end = System.nanoTime();
        System.out.println("Array Search: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        boolean hashSetFound = hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        boolean treeSetFound = treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search: " + (end - start) / 1e6 + " ms");
    }

    static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}
