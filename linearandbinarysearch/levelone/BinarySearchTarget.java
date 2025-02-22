package com.bridgelabz.linearandbinarysearch.levelone;

import java.util.Arrays;

public class BinarySearchTarget {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 7, 3, 9, 2};
        int target = 7;

        Arrays.sort(nums);

        int index = binarySearch(nums, target);

        if (index != -1) {
            System.out.println("index: " + index);
        } else {
            System.out.println(" not found.");
        }
    }
}
