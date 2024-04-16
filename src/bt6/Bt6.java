package bt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

public class Bt6 {
    private static Map<String, Integer> countWordFrequencies(String filePath) throws IOException {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\W+");
            for (String word : words
            ) {
                if (!word.isEmpty()) {
                    String cleanedWord = word.toLowerCase();
                    wordFrequencies.put(cleanedWord, wordFrequencies.getOrDefault(cleanedWord, 0) + 1);

                }

            }
        }
        reader.close();
        return wordFrequencies;
    }

    private static String findMostFrequentWord(Map<String, Integer> wordFrequencies) {
        int maxFrequency = 0;
        String mostFrequentWord = null;
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()
        ) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentWord = entry.getKey();
            }

        }
        return mostFrequentWord;
    }

    public static void main(String[] args) {
        String filePath = "src/bt6/data.txt";
        try {
            Map<String, Integer> wordFrequencies = countWordFrequencies(filePath);
            String mostFrequentWord = findMostFrequentWord(wordFrequencies);
            int maxFrequency = wordFrequencies.get(mostFrequentWord);
            System.out.println("Từ được sử dụng nhiều nhất: " + mostFrequentWord);
            System.out.println("Tần suất xuất hiện: " + maxFrequency);
        }catch (IOException e){
            System.out.println("Lỗi đọc file: " + e.getMessage());

        }
    }
}
