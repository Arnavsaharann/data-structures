package com.bridgelabz.SortingAlgorithms.levelone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortStudentAgesUsingCountingSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(23);
        arr.add(54);
        arr.add(12);
        arr.add(45);
        arr.add(56);
        arr.add(34);

        countingSort(arr);

        System.out.println(arr);
    }

    public static void countingSort(ArrayList<Integer> arr){
        int maxElement = Collections.max(arr);
        int minElement = Collections.min(arr);

        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i : arr){
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                mp.put(i, 1);
            }
        }
        int index = 0;
        for (int i = minElement; i <= maxElement; i++) {
            if (mp.containsKey(i) && mp.get(i) > 0) {
                while (mp.get(i) != 0) {
                    arr.set(index, i);
                    mp.put(i, mp.get(i) - 1);
                    index++;
                }
            }
        }
    }
}
