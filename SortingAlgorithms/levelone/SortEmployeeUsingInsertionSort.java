package com.bridgelabz.SortingAlgorithms.levelone;

import java.util.Arrays;

public class SortEmployeeUsingInsertionSort {
    public static void main(String[] args) {
        int[] IDs = { 101, 111, 105, 121, 145, 190, 125};
        System.out.println(Arrays.toString(IDs));
        System.out.println("----------------------------------------------");
        insertionSort(IDs);

        System.out.println(Arrays.toString(IDs));
    }

    public static void insertionSort(int array[]) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
}
