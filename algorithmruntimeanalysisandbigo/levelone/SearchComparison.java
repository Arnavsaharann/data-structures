package com.bridgelabz.algorithmruntimeanalysisandbigo.levelone;

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000}; // Different dataset sizes
        Random random = new Random();


        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }

            int target = data[random.nextInt(size)]; // Pick a random target from the dataset

            // Measure Linear Search time
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            // Sort for Binary Search
            Arrays.sort(data);

            // Measure Binary Search time
            startTime = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + (linearTime / 1e6));
            System.out.println("Binary Search Time: " + (binaryTime / 1e6));
            System.out.println("----------------------------------------------------");
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
