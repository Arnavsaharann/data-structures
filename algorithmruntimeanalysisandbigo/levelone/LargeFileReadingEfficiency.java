package com.bridgelabz.algorithmruntimeanalysisandbigo.levelone;

import java.io.*;

public class LargeFileReadingEfficiency {
    public static void main(String[] args) {
        String filePath = "/path/to/largefile.txt";

        long start, end;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {
            start = System.nanoTime();
            while (br.read() != -1) {}
            end = System.nanoTime();
            System.out.println("FileReader Time: " + (end - start) / 1e6 );
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            start = System.nanoTime();
            while (br.read() != -1) {}
            end = System.nanoTime();
            System.out.println("InputStreamReader Time: " + (end - start) / 1e6 );
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
