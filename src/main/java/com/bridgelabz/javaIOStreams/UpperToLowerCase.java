package com.bridgelabz.javaIOStreams;
import java.io.*;

public class UpperToLowerCase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output2.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("Text converted to lowercase successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

