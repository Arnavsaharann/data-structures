package com.bridgelabz.algorithmruntimeanalysisandbigo.levelone;

import java.util.ArrayList;
import java.util.Arrays;

public class abc {

    public static boolean firstDigitCheck(int num){
        while(num >= 10){
            num /= 10;
        }
        return num == 5;
    }
    public static void main(String[] args) {
        int[] arr = {155,551,55,65,32,56,99};

        Arrays.stream(arr).filter(abc::firstDigitCheck).forEach(System.out::println);
    }
}
