package com.bridgelabz.linearandbinarysearch.levelone;


import java.util.Scanner;

public class SearchForTheFirstNegativeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = input.nextInt();
        }

        int positionOfFirstNegativeNumber = firstNegativeNumber(numbers);

        if(positionOfFirstNegativeNumber == -1){
            System.out.println("No negative number present");

        }else{
            System.out.println("the first negative element was found at index: " + positionOfFirstNegativeNumber);
        }
    }

    public static int firstNegativeNumber(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < 0) return i;
        }
        return -1;
    }
}
