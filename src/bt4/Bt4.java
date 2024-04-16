package bt4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bt4 {
    public static void main(String[] args) {
        String sourceFilePath = "src/Exercise4/file2.txt";
        String destinationFilePath = "src/Exercise4/copyFile2.txt";

        try {
            FileReader fileReader = new FileReader(sourceFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(destinationFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = words.length - 1; i >= 0; i--) {
                    bufferedWriter.write(words[i] + " ");
                }
                bufferedWriter.newLine();
            }


            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Đã tạo bản sao của file với các từ đã đảo ngược thành công.");
            System.out.println("Nội dung của file gốc:");
            printFileContent(sourceFilePath);
            System.out.println("Nội dung của file đã đảo ngược:");
            printFileContent(destinationFilePath);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc hoặc ghi tệp: " + e.getMessage());
        }
    }

    private static void printFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
