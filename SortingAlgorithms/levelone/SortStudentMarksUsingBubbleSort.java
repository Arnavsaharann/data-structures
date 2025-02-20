package com.bridgelabz.SortingAlgorithms.levelone;

public class SortStudentMarksUsingBubbleSort {
    public static void main(String[] args) {
        int[] arr = {23, 12, 5, 422, 4, 5, 66, 20, 19, 17};

        for(int i : arr){
            System.out.println(i);
        }

        System.out.println("-------------------------------------------");
        sort(arr);

        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean swapped = false;
            for(int j = 0; j < arr.length - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
