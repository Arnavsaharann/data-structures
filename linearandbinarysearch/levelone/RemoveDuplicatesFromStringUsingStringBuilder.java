package com.bridgelabz.linearandbinarysearch.levelone;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesFromStringUsingStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word you want to remove duplicates from: ");
        String input = scanner.nextLine();

        String uniqueChars = removeDuplicates(input);

        System.out.println("String after removing duplicates: " + uniqueChars);

        scanner.close();
    }

    public static String removeDuplicates(String userInput) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char ch : userInput.toCharArray()) {
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }
        return sb.toString();
    }
}
