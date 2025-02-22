package com.bridgelabz.linearandbinarysearch.levelone;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInputAndWriteToFileUsingInputStreamReader {
    public static void main(String[] args) {
        String filePath = "/Users/arnavsaharan/Desktop/JavaClassroom/src/com/bridgelabz/linearandbinarysearch/levelone/example.txt";
        try(InputStreamReader inputStreamReader = new InputStreamReader(System.in); // Reads bytes from System.in and converts to characters
            BufferedReader reader = new BufferedReader(inputStreamReader); // Buffers input for efficient reading
            FileWriter writer = new FileWriter(filePath) // Writes user input to the file
        ) {
            String line;
            while((line = reader.readLine()) != null){
                if (line.equalsIgnoreCase("exit")) {  // Stop if user types "exit"
                    break;
                }
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
