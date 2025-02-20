package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.*;


import static java.lang.Math.max;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 7, 8));

        int longestSequence = findLongestSequence(arr);

        System.out.println("The longest sequence is: " + longestSequence);

    }

    public static int findLongestSequence(ArrayList<Integer> arr){
        Map<Integer,Boolean> mp = new HashMap<>();
        for(int num : arr){
            mp.putIfAbsent(num,false);
        }

        int maxLen = 0;
        for(int num : arr){
            if(mp.get(num)) continue;
            if(!mp.containsKey(num - 1)){
                int count = 0;
                while(mp.containsKey(num)){
                    mp.put(num, true);
                    count++;
                    num++;

                }
                maxLen = max(count,maxLen);
            }
        }
        return maxLen;
    }
}
