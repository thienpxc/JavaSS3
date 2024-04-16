package bt7;

import java.io.*;


public class bt7 {
    public static void main(String[] args) {
        String filePath = "people.bin";
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            // Đọc danh sách các đối tượng từ file
            Object obj = objectIn.readObject();
            if (obj instanceof Person[]) {
                Person[] people = (Person[]) obj;
                // Hiển thị danh sách lên màn hình
                for (Person person : people) {
                    System.out.println(person);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
