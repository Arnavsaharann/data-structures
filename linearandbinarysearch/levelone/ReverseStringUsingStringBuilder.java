package com.bridgelabz.linearandbinarysearch.levelone;

import java.util.Scanner;

public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        String reversedString = reverseString(input);

        System.out.println("Reversed string: " + reversedString);

        scanner.close();
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString(); // Converts StringBuilder back to String
    }
}

