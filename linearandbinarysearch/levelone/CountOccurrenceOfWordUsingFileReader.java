package com.bridgelabz.linearandbinarysearch.levelone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrenceOfWordUsingFileReader {
    public static void main(String[] args) {
        String filePath = "/Users/arnavsaharan/Desktop/JavaClassroom/src/com/bridgelabz/linearandbinarysearch/levelone/example.txt"; // Change this to the file path
        String targetWord = "java";

        int count = countWordOccurrences(filePath, targetWord);

        System.out.println("The word appears " + count + " times in the file.");

    }

    public static int countWordOccurrences(String filePath, String targetWord){
        int count = 0;
        targetWord = targetWord.toLowerCase();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e){
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return count;
    }
}
