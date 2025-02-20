package com.bridgelabz.SortingAlgorithms.levelone;

import java.util.ArrayList;
import java.util.Collections;

public class SortProductPricesUsingQuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(23);
        arr.add(54);
        arr.add(12);
        arr.add(45);
        arr.add(56);
        arr.add(34);

        quickSort(arr, 0, arr.size() - 1);

        System.out.println(arr);
    }

    public static void quickSort(ArrayList<Integer>arr, int low, int high){
        if(low >= high){
            return;
        }
        int partitionIndex = partition(arr, low, high);
        quickSort(arr,low,partitionIndex - 1);
        quickSort(arr,partitionIndex+1,high);
    }

    public static int partition(ArrayList<Integer>arr, int low, int high){
        int pivot = arr.get(low);
        int left = low;
        int right = high;

        while(left < right){
            while(arr.get(left) <= pivot && left < high){
                left++;
            }
            while(arr.get(right) > pivot && right > low ){
                right--;
            }
            if(left < right) Collections.swap(arr, left, right);
        }
        Collections.swap(arr, low, right);

        return right;
    }
}
