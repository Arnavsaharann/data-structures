package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllSubarraysWithZeroSum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, -6, 7};

        List<List<Integer>> result = findAllZeroSumSubarrays(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> findAllZeroSumSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                result.add(List.of(0, i));
            }

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(List.of(start + 1, i));
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);

        }
        return result;
    }
}
