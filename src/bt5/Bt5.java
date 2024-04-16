package bt5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bt5 {
    public static void main(String[] args) {
        String filePath = "src/Ex5/countries.csv"; // Thay đổi đường dẫn này thành đường dẫn tới file CSV của bạn

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            List<Country> countryList = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Country country = new Country(Integer.parseInt(fields[0]), fields[1].replace("\"", ""), fields[2].replace("\"", ""));
                countryList.add(country);
            }

            reader.close();

            for (Country country : countryList) {
                System.out.println(country);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

class Country {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}