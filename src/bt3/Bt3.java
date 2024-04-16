package bt3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bt3 {

    public static void main(String[] args) {
        String fileName = "src/exercise3/sample.txt";

        List<String> longestWords = findLongestWords(fileName);

        if (!longestWords.isEmpty()) {
            System.out.println("Longest words in the file:");
            for (String word : longestWords) {
                System.out.println(word + " - Length: " + word.length());
            }
        } else {
            System.out.println("No words found in the file.");
        }
    }

    private static List<String> findLongestWords(String fileName) {
        List<String> longestWords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int maxLength = 0;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    int length = word.length();
                    if (length > maxLength) {
                        maxLength = length;
                        longestWords.clear();
                        longestWords.add(word);
                    } else if (length == maxLength) {
                        longestWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return longestWords;
    }
}

