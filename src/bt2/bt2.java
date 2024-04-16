package bt2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class bt2 {
    public static void main(String[] args) {
        if (args.length !=2){
            System.out.println("Usage: java FileCopy <source file> <target file>");
            return;
        }
        String sourceFile = args[0];
        String targetFile = args[1];
        File source = new File(sourceFile);
        File target = new File(targetFile);
        if (!source.exists()){
            System.out.println("Tệp nguồn không tồn tại.");
            return;
        }
        if (target.exists()){
            System.out.println("Tệp mục tiêu đã tồn tại.");
            return;
        }
        try (FileInputStream fileIn = new FileInputStream(source);
             FileOutputStream fileOut = new FileOutputStream(target)){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileIn.read(buffer)) != 1){
                fileOut.write(buffer,0,bytesRead);
            }
            System.out.println("File copied successfully.");
            System.out.println("Number of bytes copied: " + target.length());

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
