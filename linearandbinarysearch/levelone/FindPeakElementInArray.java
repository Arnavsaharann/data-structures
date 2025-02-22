package com.bridgelabz.linearandbinarysearch.levelone;

public class FindPeakElementInArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 5, 6, 4};
        int peakElementIndex = findPeakElement(array);
        System.out.println(peakElementIndex);
    }

    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
