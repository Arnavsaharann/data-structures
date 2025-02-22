package com.bridgelabz.linearandbinarysearch.levelone;

import java.util.Arrays;

public class FindFirstAndLastOccurrenceOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int firstPos = findFirstPos(nums, target);
        int lastPos = findLastPos(nums, target);

        if (firstPos == nums.length || nums[firstPos] != target) {
            System.out.println(Arrays.toString(new int[]{-1, -1}));
        } else {
            System.out.println(Arrays.toString(new int[]{firstPos, lastPos}));
        }
    }

    public static int findFirstPos(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findLastPos(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
