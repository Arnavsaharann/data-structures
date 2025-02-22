package com.bridgelabz.linearandbinarysearch.levelone;

public class FirstMissingPositive {
    public static int findFirstMissingPositive(int[] nums) {
        int expected = 1;
        for (int num : nums) {
            if (num == expected) {
                expected++;
            } else if (num > expected) {
                return expected;
            }
        }
        return expected;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7};
        System.out.println("First missing positive integer: " + findFirstMissingPositive(nums));
    }
}
