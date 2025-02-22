package com.bridgelabz.linearandbinarysearch.levelone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingFileReader {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/arnavsaharan/Desktop/JavaClassroom/src/com/bridgelabz/linearandbinarysearch/levelone/example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
