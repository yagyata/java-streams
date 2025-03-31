package com.bridgelabz.javaIOStreams;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/bridgelabz/javaIOStreams/file.txt"))){
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
            return ;
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 most frequently occurring words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if (++count == 5) break;
        }
    }
}
