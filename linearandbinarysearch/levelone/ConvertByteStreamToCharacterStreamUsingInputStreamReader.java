package com.bridgelabz.linearandbinarysearch.levelone;

import java.io.*;

public class ConvertByteStreamToCharacterStreamUsingInputStreamReader {
    public static void main(String[] args) {
        String filePath = "/Users/arnavsaharan/Desktop/JavaClassroom/src/com/bridgelabz/linearandbinarysearch/levelone/example.txt"; // Update the file path
        String charset = "UTF-8"; // Encoding format
        readAndPrintFile(filePath, charset);

    }

    public static void readAndPrintFile(String filePath, String charset) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset))) {
            // BufferedReader: Efficiently reads text line by line
            // InputStreamReader: Converts byte stream (FileInputStream) to character stream using the specified charset
            // FileInputStream: Reads raw bytes from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
