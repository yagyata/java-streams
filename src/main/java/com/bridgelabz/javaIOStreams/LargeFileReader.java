package com.bridgelabz.javaIOStreams;
import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/javaIOStreams/largeFile.txt";
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    // Print only lines containing "error"
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Word \"error\" not found in the file.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
