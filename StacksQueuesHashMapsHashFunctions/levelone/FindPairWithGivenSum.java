package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.*;

public class FindPairWithGivenSum {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 7, 8));
        int target = 6;
        int[] result = findPair(arr,target);

        System.out.println(Arrays.toString(result));
    }
    public static int[] findPair(ArrayList<Integer> arr, int target){
        HashMap<Integer,Integer>mp = new HashMap<>();

        for(int i = 0; i < arr.size(); i++ ){
            int complement = target - arr.get(i);
            if(mp.containsKey(complement)){
                return new int[] {mp.get(complement), i};
            }
            mp.put(arr.get(i), i);
        }
        return new int[] {-1, -1};
    }
}
