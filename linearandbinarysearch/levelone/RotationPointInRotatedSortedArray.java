package com.bridgelabz.linearandbinarysearch.levelone;

public class RotationPointInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};

        int rotationIndex = getRotationPoint(array);

        System.out.println("Rotation Point Index: " + rotationIndex);

    }
    public static int getRotationPoint(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        int minElement = 10000;

        while(low <= high){
            int mid = low + (high - low)/2;

            //left Sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] < minElement) {
                    minElement = nums[low];
                    index = low;
                }
                low = mid + 1;
            } else { // Right sorted
                if (nums[mid] < minElement) {
                    minElement = nums[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }

        return index;
    }
}
