package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.Arrays;  // Import Arrays for sum()

public class CircularTourProblem {
    public static int canCompleteCircuit(int[] gas, int[] distance) {
        int n = gas.length;
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(distance).sum();

        if(totalCost > totalGas) return -1;

        int currentFuel = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            currentFuel += gas[i] - distance[i];

            if(currentFuel < 0){
                start = i + 1;
                currentFuel = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 8};
        int[] distance = {6, 9, 3, 5};

        int start = canCompleteCircuit(petrol, distance);
        System.out.println("Start at petrol pump index: " + start);
    }


}
