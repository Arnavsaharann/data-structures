package com.bridgelabz.algorithmruntimeanalysisandbigo.levelone;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        Random random = new Random();

        for (int size : sizes) {
            int[] bubbleArray = new int[size];
            int[] mergeArray = new int[size];
            int[] quickArray = new int[size];


            for (int i = 0; i < size; i++) {
                int value = random.nextInt(size * 10);
                bubbleArray[i] = mergeArray[i] = quickArray[i] = value;
            }

            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long bubbleTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            mergeSort(mergeArray, 0, size - 1);
            long mergeTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            quickSort(quickArray, 0, size - 1);
            long quickTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time  " + (bubbleTime / 1e6));
            System.out.println("Merge Sort Time  " + (mergeTime / 1e6));
            System.out.println("Quick Sort Time " + (quickTime / 1e6));
            System.out.println("----------------------------------------");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
