package bt1;

import java.io.*;


public class Baitap1 {
    public static void main(String[] args) {

            String file = "src/bt1/data/hello.txt";
        try {
            System.out.println(file.length());
            String content =  readFileContent(new File(file.toString())); // Đọc nội dung file
            int wordCount = countWords(content); // Đếm số lượng từ
            System.out.println("Số lượng từ trong file: " + wordCount);
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    // Hàm đọc file và trả về nội dung dưới dạng String
    private static String readFileContent(File filePath) throws IOException {
        StringBuffer contentBuilder = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            contentBuilder.append(line).append("\n");
        }
        reader.close();
        return contentBuilder.toString();
    }
    // Hàm đếm số lượng từ trong một chuỗi
    private static int countWords (String content){
        // Loại bỏ các ký tự không phải chữ cái hoặc số
        content = content.replaceAll("[^\\w\\s]","");
        // Tách chuỗi thành mảng các từ
        String[] words = content.split("\\s+");
        // Trả về độ dài của mảng (số lượng từ)
        return words.length;
    }

}
