package com.bridgelabz.SortingAlgorithms.levelone;

import java.util.ArrayList;
import java.util.Collections;

public class SortExamScoresUsingSelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(23);
        arr.add(54);
        arr.add(12);
        arr.add(45);
        arr.add(56);
        arr.add(34);

        selectionSort(arr);
        System.out.println(arr);
    }
    public static void selectionSort(ArrayList<Integer> arr){
        int n = arr.size();
        for(int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for(int j = i + 1; j < n; j++){
                if(arr.get(j) < arr.get(minIdx)){
                    minIdx = j;
                }
            }
            Collections.swap(arr, i, minIdx);
        }
    }
}
