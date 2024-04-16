package bt7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateBinaryFile {
    public static void main(String[] args) {

        Person[] people = {
                new Person("thien", 5),
                new Person("dep", 10),
                new Person("trai", 15)
        };

        try (FileOutputStream fileOut = new FileOutputStream("people.bin");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            // Ghi danh sách các đối tượng vào file
            objectOut.writeObject(people);
            System.out.println("Đã tạo file people.bin thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
