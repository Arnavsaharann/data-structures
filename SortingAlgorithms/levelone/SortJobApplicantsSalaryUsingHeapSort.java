package com.bridgelabz.SortingAlgorithms.levelone;

import java.util.ArrayList;
import java.util.Collections;

public class SortJobApplicantsSalaryUsingHeapSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(50000);
        arr.add(70000);
        arr.add(45000);
        arr.add(80000);
        arr.add(60000);

        heapSort(arr);

        for (int salary : arr) {
            System.out.print(salary + " ");
        }
    }

    public static void heapSort(ArrayList<Integer> arr) {
        int n = arr.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            Collections.swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(ArrayList<Integer> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        if (right < n && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            Collections.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}

