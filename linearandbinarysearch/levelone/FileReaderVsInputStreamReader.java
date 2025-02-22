package com.bridgelabz.linearandbinarysearch.levelone;

import java.io.*;

public class FileReaderVsInputStreamReader {
    public static void main(String[] args) {
        String filePath = "/Users/arnavsaharan/Desktop/JavaClassroom/src/com/bridgelabz/linearandbinarysearch/levelone/largefile.txt";

        long startTime = System.nanoTime();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - startTime;
        System.out.println("FileReader Word Count: " + wordCountFileReader);
        System.out.println("FileReader Time (ms): " + (fileReaderTime / 1e6));

        startTime = System.nanoTime();
        int wordCountStreamReader = countWordsUsingInputStreamReader(filePath);
        long streamReaderTime = System.nanoTime() - startTime;
        System.out.println("InputStreamReader Word Count: " + wordCountStreamReader);
        System.out.println("InputStreamReader Time (ms): " + (streamReaderTime / 1e6));
    }

    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file using FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file using InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
